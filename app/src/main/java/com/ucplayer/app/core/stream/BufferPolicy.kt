package com.ucplayer.app.core.stream

class BufferPolicy {
    fun getStartupBufferSize(dlSpeedBytesPerSec: Long): Long {
        return EngineConfig.startupBufferBytes
    }

    fun getRollingBufferSize(dlSpeedBytesPerSec: Long): Long {
        return EngineConfig.rollingBufferBytes
    }
}
