package com.ucplayer.app.core.stream

import com.ucplayer.app.core.stream.models.MediaInfo

class HttpMetadataProvider(
    private val byteSource: HttpByteSource,
    private val url: String
) : MediaMetadataProvider {
    override suspend fun mediaInfo(): MediaInfo {
        val size = byteSource.getContentLength()
        val title = url.substringAfterLast("/").substringBefore("?")
        return MediaInfo(
            title = if (title.length > 3) title else "HTTP Video Stream",
            size = if (size > 0) size else null,
            mimeType = "video/mp4",
            durationMs = null,
            isSeekable = size > 0
        )
    }
}
