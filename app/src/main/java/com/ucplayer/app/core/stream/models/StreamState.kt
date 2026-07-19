package com.ucplayer.app.core.stream.models

enum class StreamState {
    CREATED,
    PREPARING,
    BUFFERING,
    PLAYING,
    PAUSED,
    DOWNLOADING,
    COMPLETED,
    FAILED,
    CLOSED
}
