package com.ucplayer.app.core.stream

import android.content.Context
import com.frostwire.jlibtorrent.Priority
import com.frostwire.jlibtorrent.TorrentHandle
import com.ucplayer.app.core.torrent.PieceScheduler
import com.ucplayer.app.core.torrent.TorrentEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.RandomAccessFile

class TorrentByteSource(
    private val context: Context,
    private val torrentEngine: TorrentEngine,
    private val magnetUrl: String,
    private val sessionId: String
) : ByteSource {
    private var torrentHandle: TorrentHandle? = null
    private var scheduler: PieceScheduler? = null
    private var videoFile: File? = null
    private var pieceLength: Long = 262144
    private var videoFileOffset: Long = 0
    private var videoFileSize: Long = 0
    private var resolvedInfoHash: String? = null
    private var fileIndex: Int = -1
    private var firstPieceLogged = false

    fun getTorrentHandle(): TorrentHandle? {
        return torrentHandle
    }

    suspend fun setFileIndex(index: Int) {
        fileIndex = index
        selectFileInternal(index)
    }

    fun getVideoFileSize(): Long {
        return videoFileSize
    }

    fun getTorrentFilesList(): List<String> {
        val handle = torrentHandle ?: return emptyList()
        val torrentInfo = handle.torrentFile() ?: return emptyList()
        val files = torrentInfo.files()
        val list = mutableListOf<String>()
        for (i in 0 until files.numFiles()) {
            list.add(files.filePath(i))
        }
        return list
    }

    override suspend fun prepare() = withContext(Dispatchers.IO) {
        val saveDir = File(File(context.cacheDir, "torrents"), sessionId).apply { mkdirs() }
        
        if (magnetUrl.startsWith("http://", ignoreCase = true) || magnetUrl.startsWith("https://", ignoreCase = true)) {
            val request = okhttp3.Request.Builder().url(magnetUrl).build()
            val client = okhttp3.OkHttpClient()
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) throw java.io.IOException("HTTP error response: ${response.code}")
            val bytes = response.body?.bytes() ?: throw java.io.IOException("Empty torrent file body")
            val torrentInfo = com.frostwire.jlibtorrent.TorrentInfo(bytes)
            resolvedInfoHash = torrentInfo.infoHashV1().toHex()
            torrentEngine.sessionManager.download(torrentInfo, saveDir)
        } else {
            val ec = com.frostwire.jlibtorrent.swig.error_code()
            val p = com.frostwire.jlibtorrent.swig.add_torrent_params.parse_magnet_uri(magnetUrl, ec)
            resolvedInfoHash = magnetUrl.substringAfter("btih:", "").substringBefore("&").lowercase()
            p.save_path = saveDir.absolutePath
            torrentEngine.sessionManager.swig().add_torrent(p, ec)
        }

        var handle: TorrentHandle? = null
        while (handle == null) {
            handle = findHandle()
            if (handle == null) {
                delay(500)
            }
        }
        torrentHandle = handle
        scheduler = PieceScheduler(handle)

        while (handle.torrentFile() == null) {
            delay(500)
        }
        
        pieceLength = handle.torrentFile().pieceLength().toLong()
    }

    private var activeFileChannel: java.nio.channels.FileChannel? = null
    private var activeChannelFile: File? = null

    private fun getOrOpenFileChannel(targetFile: File): java.nio.channels.FileChannel? {
        if (activeChannelFile == targetFile && activeFileChannel?.isOpen == true) {
            return activeFileChannel
        }
        activeFileChannel?.close()
        return try {
            java.nio.channels.FileChannel.open(targetFile.toPath(), java.nio.file.StandardOpenOption.READ).also {
                activeFileChannel = it
                activeChannelFile = targetFile
            }
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun read(offset: Long, buffer: ByteArray, length: Int): Int = withContext(Dispatchers.IO) {
        // Lazy select file if not explicitly set
        if (fileIndex == -1) {
            selectFileInternal(-1)
        }

        val file = videoFile ?: return@withContext -1

        val dlSpeed = torrentHandle?.status()?.downloadRate()?.toLong() ?: 0L
        scheduler?.prioritizeByteRange(offset, length, pieceLength, videoFileOffset, dlSpeed)
        waitForPieces(offset, length)

        if (!file.exists()) {
            return@withContext -1
        }

        val channel = getOrOpenFileChannel(file) ?: return@withContext -1
        val byteBuffer = java.nio.ByteBuffer.wrap(buffer, 0, length)
        return@withContext channel.read(byteBuffer, offset)
    }

    override suspend fun close() {
        withContext(Dispatchers.IO) {
            activeFileChannel?.close()
            activeFileChannel = null
            activeChannelFile = null
            torrentHandle?.pause()
        }
    }

    private fun findHandle(): TorrentHandle? {
        val torrents = torrentEngine.sessionManager.torrentHandles
        if (torrents == null) return null
        for (t in torrents) {
            val hash = t.infoHash()?.toHex()
            if (hash != null) {
                val base32Hash = magnetUrl.substringAfter("btih:", "").substringBefore("&").lowercase()
                val hexHash = resolvedInfoHash?.lowercase()
                if (magnetUrl.contains(hash, ignoreCase = true) || 
                    hash.equals(hexHash, ignoreCase = true) || 
                    hash.equals(base32Hash, ignoreCase = true)) {
                    return t
                }
            }
        }
        return torrents.firstOrNull()
    }

    private suspend fun selectFileInternal(index: Int) {
        val handle = torrentHandle ?: return
        val torrentInfo = handle.torrentFile() ?: return
        val files = torrentInfo.files()
        val saveDir = File(File(context.cacheDir, "torrents"), sessionId)

        var targetIndex = index
        if (targetIndex == -1) {
            var maxLen = 0L
            for (i in 0 until files.numFiles()) {
                if (files.fileSize(i) > maxLen) {
                    maxLen = files.fileSize(i)
                    targetIndex = i
                }
            }
        }
        fileIndex = targetIndex
        videoFileSize = files.fileSize(targetIndex)
        videoFileOffset = files.fileOffset(targetIndex)
        
        val filePath = files.filePath(targetIndex)
        videoFile = File(saveDir, filePath)
        videoFile?.parentFile?.mkdirs()

        val priorities = Array(files.numFiles()) { i ->
            if (i == targetIndex) Priority.SEVEN else Priority.IGNORE
        }
        handle.prioritizeFiles(priorities)

        val prebufferBytes = Math.min(32 * 1024 * 1024L, videoFileSize).toInt()
        scheduler?.prioritizeByteRange(0, prebufferBytes, pieceLength, videoFileOffset)
    }

    private suspend fun waitForPieces(byteOffset: Long, length: Int) {
        val handle = torrentHandle ?: return
        val startByte = videoFileOffset + byteOffset
        val endByte = startByte + length

        val startPiece = (startByte / pieceLength).toInt()
        val endPiece = ((endByte - 1) / pieceLength).toInt()

        val numPieces = handle.torrentFile()?.numPieces() ?: 0
        while (true) {
            var allDownloaded = true
            for (p in startPiece..endPiece) {
                if (p in 0 until numPieces && !handle.havePiece(p)) {
                    allDownloaded = false
                    break
                }
            }
            if (allDownloaded) {
                if (!firstPieceLogged) {
                    firstPieceLogged = true
                    PlaybackTracker.log("First Piece Downloaded")
                }
                break
            }
            delay(30)
        }
    }
}
