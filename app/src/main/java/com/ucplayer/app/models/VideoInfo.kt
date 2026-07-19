package com.ucplayer.app.models

data class VideoInfo(
    val title: String,
    val poster: String? = null,
    val description: String? = null,
    val duration: Long? = null,
    val website: String,
    val pageUrl: String,
    val videos: List<VideoSource> = emptyList(),
    val subtitles: List<SubtitleSource> = emptyList(),
    val torrents: List<TorrentSource> = emptyList()
)

data class VideoSource(
    val quality: String,
    val url: String,
    val mimeType: String,
    val codec: String? = null,
    val bitrate: Int? = null,
    val headers: Map<String, String> = emptyMap()
)

data class SubtitleSource(
    val lang: String,
    val url: String,
    val mimeType: String
)

data class TorrentSource(
    val url: String,
    val name: String,
    val isMagnet: Boolean
)
