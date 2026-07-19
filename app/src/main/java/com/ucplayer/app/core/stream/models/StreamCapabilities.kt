package com.ucplayer.app.core.stream.models

data class StreamCapabilities(
    val canSeek: Boolean,
    val canDownload: Boolean,
    val canPause: Boolean,
    val supportsBackground: Boolean,
    val supportsOfflineAfterCache: Boolean,
    val supportsQualitySwitch: Boolean,
    val supportsCasting: Boolean,
    val supportsSubtitles: Boolean,
    val supportsPlaybackSpeed: Boolean,
    val supportsPlaylist: Boolean
)
