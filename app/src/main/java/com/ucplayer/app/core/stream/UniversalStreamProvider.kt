package com.ucplayer.app.core.stream

import android.content.Context
import com.ucplayer.app.core.stream.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.OutputStream

class UniversalStreamProvider(
    override val sessionId: String,
    private val byteSource: ByteSource,
    private val metadataProvider: MediaMetadataProvider
) : StreamProvider {
    override var metadata: MediaMetadata? = null
    private var streamState = StreamState.CREATED
    private val requestPipeline = RequestPipeline(byteSource)
    private var firstByteServedLogged = false

    override suspend fun prepare() = withContext(Dispatchers.IO) {
        streamState = StreamState.PREPARING
        byteSource.prepare()
        val info = metadataProvider.mediaInfo()
        PlaybackTracker.log("Metadata Ready")
        
        val capabilities = StreamCapabilities(
            canSeek = info.isSeekable,
            canDownload = true,
            canPause = true,
            supportsBackground = true,
            supportsOfflineAfterCache = true,
            supportsQualitySwitch = false,
            supportsCasting = true,
            supportsSubtitles = true,
            supportsPlaybackSpeed = true,
            supportsPlaylist = true
        )

        metadata = MediaMetadata(
            title = info.title,
            duration = info.durationMs,
            width = null,
            height = null,
            mimeType = info.mimeType,
            contentLength = info.size ?: 0L,
            poster = null,
            description = null,
            website = null,
            originalUrl = "",
            thumbnail = null,
            capabilities = capabilities
        )
        streamState = StreamState.BUFFERING
    }

    override suspend fun open() = withContext(Dispatchers.IO) {
        streamState = StreamState.PLAYING
    }

    override suspend fun read(offset: Long, output: OutputStream, length: Long): Long = withContext(Dispatchers.IO) {
        val bufferSize = 32 * 1024
        val buffer = ByteArray(bufferSize)
        var totalWritten = 0L

        while (totalWritten < length && streamState == StreamState.PLAYING) {
            val remaining = length - totalWritten
            val toRead = Math.min(bufferSize.toLong(), remaining).toInt()
            
            val read = requestPipeline.read(offset + totalWritten, buffer, toRead)
            if (read <= 0) break
            
            output.write(buffer, 0, read)
            output.flush()
            if (!firstByteServedLogged) {
                firstByteServedLogged = true
                PlaybackTracker.log("First Byte Served")
            }
            totalWritten += read
        }
        return@withContext totalWritten
    }

    override suspend fun stop() {
        byteSource.close()
        streamState = StreamState.PAUSED
    }

    override suspend fun close() {
        byteSource.close()
        streamState = StreamState.CLOSED
    }

    override fun getPieceStates(): List<PieceState> {
        if (byteSource is TorrentByteSource) {
            val handle = byteSource.getTorrentHandle() ?: return emptyList()
            val numPieces = handle.torrentFile()?.numPieces() ?: 0
            val states = ArrayList<PieceState>(numPieces)
            for (i in 0 until numPieces) {
                states.add(if (handle.havePiece(i)) PieceState.DOWNLOADED else PieceState.EMPTY)
            }
            return states
        }
        return emptyList()
    }

    override fun getStatistics(): StreamStatistics {
        if (byteSource is TorrentByteSource) {
            val handle = byteSource.getTorrentHandle()
            val status = handle?.status()
            val dlRate = status?.downloadRate()?.toLong() ?: 0L
            val ulRate = status?.uploadRate()?.toLong() ?: 0L
            val progress = status?.progress() ?: 0f
            return StreamStatistics(
                speed = dlRate,
                downloadRate = dlRate,
                uploadRate = ulRate,
                peers = status?.numPeers() ?: 0,
                activeConnections = status?.numConnections() ?: 0,
                seeders = status?.numSeeds() ?: 0,
                leechers = (status?.numPeers() ?: 0) - (status?.numSeeds() ?: 0),
                downloaded = status?.allTimeDownload() ?: 0L,
                uploaded = status?.allTimeUpload() ?: 0L,
                ETA = 0L,
                progress = progress,
                cacheSize = 0L,
                cachePercent = progress * 100f,
                bufferSeconds = 0.0,
                schedulerMode = SchedulerMode.STREAMING,
                streamState = streamState,
                pieceCompletion = getPieceStates()
            )
        } else if (byteSource is HttpByteSource) {
            val totalSize = metadata?.contentLength ?: 0L
            return StreamStatistics(
                speed = 0L,
                downloadRate = 0L,
                uploadRate = 0L,
                peers = 0,
                activeConnections = 1,
                seeders = 0,
                leechers = 0,
                downloaded = 0L,
                uploaded = 0L,
                ETA = 0L,
                progress = 1.0f,
                cacheSize = totalSize,
                cachePercent = 100f,
                bufferSeconds = 0.0,
                schedulerMode = SchedulerMode.STREAMING,
                streamState = streamState,
                pieceCompletion = emptyList()
            )
        }
        return StreamStatistics(
            speed = 0, downloadRate = 0, uploadRate = 0, peers = 0, activeConnections = 0,
            seeders = 0, leechers = 0, downloaded = 0, uploaded = 0, ETA = 0, progress = 0f,
            cacheSize = 0, cachePercent = 0f, bufferSeconds = 0.0, schedulerMode = SchedulerMode.STREAMING,
            streamState = streamState, pieceCompletion = emptyList()
        )
    }

    override suspend fun selectFile(fileIndex: Int) {
        if (byteSource is TorrentByteSource) {
            byteSource.setFileIndex(fileIndex)
        }
    }

    override fun getTorrentFiles(): List<String> {
        if (byteSource is TorrentByteSource) {
            return byteSource.getTorrentFilesList()
        }
        return emptyList()
    }
}
