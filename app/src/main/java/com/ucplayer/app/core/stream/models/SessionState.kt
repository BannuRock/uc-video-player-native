package com.ucplayer.app.core.stream.models

enum class SessionState {
    IDLE,
    PREPARING,
    METADATA_READY,
    BUFFERING,
    READY,
    PLAYING,
    SEEKING,
    PAUSED,
    COMPLETED,
    ERROR,
    CLOSED
}
