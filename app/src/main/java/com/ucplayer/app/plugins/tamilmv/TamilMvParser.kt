package com.ucplayer.app.plugins.tamilmv

import com.ucplayer.app.core.network.NetworkClient
import com.ucplayer.app.core.parser.ParserPlugin
import com.ucplayer.app.models.TorrentSource
import com.ucplayer.app.models.VideoInfo
import com.ucplayer.app.models.VideoSource
import org.jsoup.Jsoup
import java.net.URLDecoder
import javax.inject.Inject

class TamilMvParser @Inject constructor(
    private val networkClient: NetworkClient
) : ParserPlugin {

    override fun canHandle(url: String): Boolean {
        val lower = url.lowercase()
        return lower.contains("tamilmv") || lower.contains("1tamilmv")
    }

    override suspend fun extract(url: String): VideoInfo {
        // Fetch raw HTML using our shared network client
        val html = networkClient.getHtml(url)
        val doc = Jsoup.parse(html)
        val title = doc.title() ?: "TamilMV Media"

        val videos = mutableListOf<VideoSource>()
        val torrents = mutableListOf<TorrentSource>()

        val anchors = doc.select("a")
        for (anchor in anchors) {
            val href = anchor.attr("href").trim()
            val text = anchor.text().trim()
            val fileExt = anchor.attr("data-fileext").trim()

            if (href.isEmpty()) continue

            if (href.startsWith("magnet:", ignoreCase = true)) {
                val dn = getMagnetName(href)
                torrents.add(TorrentSource(url = href, name = dn, isMagnet = true))
            } else {
                val isTorrent = href.endsWith(".torrent", ignoreCase = true) ||
                        fileExt.equals("torrent", ignoreCase = true) ||
                        (href.contains("attachment.php", ignoreCase = true) && text.lowercase().contains(".torrent"))

                if (isTorrent) {
                    val fallbackName = if (text.isNotEmpty()) text else href.split("/").lastOrNull()?.split("?")?.firstOrNull() ?: "Torrent File"
                    val resolvedUrl = resolveUrl(url, href)
                    torrents.add(TorrentSource(url = resolvedUrl, name = fallbackName, isMagnet = false))
                } else if (href.endsWith(".m3u8", ignoreCase = true) || href.endsWith(".mp4", ignoreCase = true)) {
                    val resolvedUrl = resolveUrl(url, href)
                    val mime = if (href.endsWith(".m3u8", ignoreCase = true)) "application/x-mpegURL" else "video/mp4"
                    videos.add(VideoSource(quality = "Source", url = resolvedUrl, mimeType = mime))
                }
            }
        }

        return VideoInfo(
            title = title,
            website = "TamilMV",
            pageUrl = url,
            videos = videos,
            torrents = torrents
        )
    }

    private fun getMagnetName(magnetUrl: String): String {
        try {
            val match = Regex("[&?]dn=([^&]+)", RegexOption.IGNORE_CASE).find(magnetUrl)
            if (match != null) {
                return URLDecoder.decode(match.groupValues[1].replace("+", " "), "UTF-8")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "Magnet Resource"
    }

    private fun resolveUrl(baseUrl: String, relativeUrl: String): String {
        return try {
            java.net.URL(java.net.URL(baseUrl), relativeUrl).toString()
        } catch (e: Exception) {
            relativeUrl
        }
    }
}
