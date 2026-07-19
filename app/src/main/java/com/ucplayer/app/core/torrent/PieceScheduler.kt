package com.ucplayer.app.core.torrent

import com.frostwire.jlibtorrent.TorrentFlags
import com.frostwire.jlibtorrent.Priority
import com.frostwire.jlibtorrent.TorrentHandle
import com.ucplayer.app.core.stream.models.SchedulerMode

class PieceScheduler(private val handle: TorrentHandle) {
    private var mode = SchedulerMode.STREAMING
    private var lastHighStartPiece = -1

    init {
        applySchedulingRules()
    }

    fun getMode(): SchedulerMode = mode

    fun setMode(newMode: SchedulerMode) {
        if (mode == newMode) return
        mode = newMode
        applySchedulingRules()
    }

    private fun applySchedulingRules() {
        val numPieces = handle.torrentFile()?.numPieces() ?: 0
        when (mode) {
            SchedulerMode.STREAMING -> {
                handle.setFlags(TorrentFlags.SEQUENTIAL_DOWNLOAD)
            }
            SchedulerMode.DOWNLOAD -> {
                handle.unsetFlags(TorrentFlags.SEQUENTIAL_DOWNLOAD)
                // Restore standard priority for all pieces
                for (i in 0 until numPieces) {
                    handle.piecePriority(i, Priority.NORMAL)
                }
            }
            SchedulerMode.PREVIEW -> {
                handle.setFlags(TorrentFlags.SEQUENTIAL_DOWNLOAD)
                // Maximize download priority of beginning and end chunks
                val edgeBound = 8
                for (i in 0 until numPieces) {
                    val isEdge = (i < edgeBound || i >= numPieces - edgeBound)
                    handle.piecePriority(i, if (isEdge) Priority.SEVEN else Priority.NORMAL)
                }
            }
            SchedulerMode.SMART_BUFFER -> {
                handle.setFlags(TorrentFlags.SEQUENTIAL_DOWNLOAD)
                // Buffer first 20 pieces and normal sequential download afterwards
                for (i in 0 until numPieces) {
                    val isStart = i < 20
                    handle.piecePriority(i, if (isStart) Priority.SEVEN else Priority.NORMAL)
                }
            }
            else -> {
                handle.setFlags(TorrentFlags.SEQUENTIAL_DOWNLOAD)
            }
        }
    }

    fun prioritizeByteRange(
        byteOffset: Long,
        length: Int,
        pieceLength: Long,
        fileOffset: Long,
        dlSpeedBytesPerSec: Long = 0L
    ) {
        val numPieces = handle.torrentFile()?.numPieces() ?: 0
        if (numPieces <= 0) return

        val startByte = fileOffset + byteOffset
        val highStartPiece = (startByte / pieceLength).toInt()

        // CPU Optimization: skip updating priorities if playback head hasn't crossed to a new piece
        if (highStartPiece == lastHighStartPiece) return
        lastHighStartPiece = highStartPiece

        val highPriorityBytes = 32 * 1024 * 1024L // 32 MB startup/immediate buffer
        val mediumPriorityBytes = 256 * 1024 * 1024L // 256 MB rolling streaming buffer

        // High priority piece range
        val highEndPiece = ((startByte + highPriorityBytes) / pieceLength).toInt()

        // Medium priority piece range
        val medStartPiece = highEndPiece + 1
        val medEndPiece = ((startByte + highPriorityBytes + mediumPriorityBytes) / pieceLength).toInt()

        // Apply sliding window priorities to reduce loop overhead
        val searchStart = Math.max(0, highStartPiece - 50)
        val searchEnd = Math.min(numPieces - 1, medEndPiece + 50)
        
        for (p in searchStart..searchEnd) {
            val isHigh = p in highStartPiece..highEndPiece
            val isMedium = p in medStartPiece..medEndPiece
            
            if (isHigh) {
                handle.piecePriority(p, Priority.SEVEN)
                handle.setPieceDeadline(p, 1000)
            } else if (isMedium) {
                handle.piecePriority(p, Priority.FIVE)
                handle.resetPieceDeadline(p)
            } else {
                handle.piecePriority(p, Priority.NORMAL)
                handle.resetPieceDeadline(p)
            }
        }
    }
}
