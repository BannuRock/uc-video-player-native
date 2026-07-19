package com.ucplayer.app.core.stream.models

enum class PieceState {
    EMPTY,
    REQUESTED,
    DOWNLOADING,
    DOWNLOADED,
    VERIFIED,
    FAILED,
    SKIPPED
}
