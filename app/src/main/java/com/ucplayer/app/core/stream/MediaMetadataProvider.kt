package com.ucplayer.app.core.stream

import com.ucplayer.app.core.stream.models.MediaInfo

interface MediaMetadataProvider {
    suspend fun mediaInfo(): MediaInfo
}
