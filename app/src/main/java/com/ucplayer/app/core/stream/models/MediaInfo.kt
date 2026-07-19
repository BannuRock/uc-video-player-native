package com.ucplayer.app.core.stream.models

data class MediaInfo(
    val title: String,
    val size: Long?, // Nullable for live streams or unparsed sizes
    val mimeType: String,
    val durationMs: Long?, // Nullable until resolved
    val isSeekable: Boolean
)
