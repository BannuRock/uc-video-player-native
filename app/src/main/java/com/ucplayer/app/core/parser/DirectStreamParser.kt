package com.ucplayer.app.core.parser

import com.ucplayer.app.models.TorrentSource
import com.ucplayer.app.models.VideoInfo
import com.ucplayer.app.models.VideoSource
import javax.inject.Inject

class DirectStreamParser @Inject constructor() : ParserPlugin {

    override fun canHandle(url: String): Boolean {
        val lower = url.lowercase()
        return lower.endsWith(".m3u8") || lower.endsWith(".mp4") || lower.startsWith("magnet:") ||
                lower.endsWith(".torrent") || lower.contains(".torrent") || lower.contains("attachment.php")
    }

    override suspend fun extract(url: String): VideoInfo {
        val lower = url.lowercase()
        if (url.startsWith("magnet:", ignoreCase = true) ||
            lower.endsWith(".torrent") || lower.contains(".torrent") || lower.contains("attachment.php")
        ) {
            val isMagnet = url.startsWith("magnet:", ignoreCase = true)
            return VideoInfo(
                title = if (isMagnet) "Magnet Link" else "Torrent File",
                website = if (isMagnet) "Magnet" else "Torrent",
                pageUrl = url,
                torrents = listOf(TorrentSource(url = url, name = if (isMagnet) "Magnet Link" else "Torrent File", isMagnet = isMagnet))
            )
        }

        val isHls = url.endsWith(".m3u8", ignoreCase = true)
        val filename = url.split("/").lastOrNull()?.split("?")?.firstOrNull() ?: "Direct Stream"
        val mime = if (isHls) "application/x-mpegURL" else "video/mp4"

        return VideoInfo(
            title = filename,
            website = "Direct Stream",
            pageUrl = url,
            videos = listOf(
                VideoSource(
                    quality = "Source",
                    url = url,
                    mimeType = mime
                )
            )
        )
    }
}
