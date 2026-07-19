package com.ucplayer.app.core.stream

import android.content.Context
import com.ucplayer.app.core.torrent.TorrentEngine

class TorrentSourceFactory(
    private val context: Context,
    private val torrentEngine: TorrentEngine
) : ByteSourceFactory {
    override fun canHandle(url: String): Boolean {
        return url.startsWith("magnet:") || url.contains("btih:") || url.endsWith(".torrent") || url.contains(".torrent") || url.contains("attachment.php")
    }

    override fun createByteSource(url: String, sessionId: String): ByteSource {
        return TorrentByteSource(context, torrentEngine, url, sessionId)
    }

    override fun createMetadataProvider(byteSource: ByteSource, url: String): MediaMetadataProvider {
        return TorrentMetadataProvider(byteSource as TorrentByteSource)
    }
}
