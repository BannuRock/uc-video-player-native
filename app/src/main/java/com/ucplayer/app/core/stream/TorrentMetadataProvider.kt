package com.ucplayer.app.core.stream

import com.ucplayer.app.core.stream.models.MediaInfo

class TorrentMetadataProvider(private val byteSource: TorrentByteSource) : MediaMetadataProvider {
    override suspend fun mediaInfo(): MediaInfo {
        val handle = byteSource.getTorrentHandle() ?: throw IllegalStateException("Torrent source not prepared")
        val torrentInfo = handle.torrentFile() ?: throw IllegalStateException("Metadata not resolved")
        return MediaInfo(
            title = torrentInfo.name(),
            size = byteSource.getVideoFileSize(),
            mimeType = "video/mp4",
            durationMs = null,
            isSeekable = true
        )
    }
}
