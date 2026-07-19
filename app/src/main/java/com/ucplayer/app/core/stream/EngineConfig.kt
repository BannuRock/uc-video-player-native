package com.ucplayer.app.core.stream

object EngineConfig {
    var startupBufferBytes: Long = 32 * 1024 * 1024L // 32 MB
    var rollingBufferBytes: Long = 256 * 1024 * 1024L // 256 MB
    var memoryCacheLimitBytes: Long = 64 * 1024 * 1024L // 64 MB
    var diskCacheLimitBytes: Long = 512 * 1024 * 1024L // 512 MB
    var requestTimeoutMs: Long = 10000L // 10 seconds
}
