package com.ucplayer.app.core.stream.models

data class StreamStatistics(
    val speed: Long,
    val downloadRate: Long,
    val uploadRate: Long,
    val peers: Int,
    val activeConnections: Int,
    val seeders: Int,
    val leechers: Int,
    val downloaded: Long,
    val uploaded: Long,
    val ETA: Long,
    val progress: Float,
    val cacheSize: Long,
    val cachePercent: Float,
    val bufferSeconds: Double,
    val schedulerMode: SchedulerMode,
    val streamState: StreamState,
    val pieceCompletion: List<PieceState>
)
