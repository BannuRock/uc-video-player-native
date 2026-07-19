package com.ucplayer.app.core.stream.models

data class MediaMetadata(
    val title: String,
    val duration: Long?,
    val width: Int?,
    val height: Int?,
    val mimeType: String,
    val contentLength: Long,
    val poster: String?,
    val description: String?,
    val audioTracks: List<String> = emptyList(),
    val subtitleTracks: List<String> = emptyList(),
    val website: String?,
    val originalUrl: String,
    val thumbnail: String?,
    val capabilities: StreamCapabilities
)
