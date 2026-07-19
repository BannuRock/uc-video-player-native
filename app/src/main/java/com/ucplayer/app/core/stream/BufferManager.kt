package com.ucplayer.app.core.stream

class BufferManager(private val bufferPolicy: BufferPolicy) {
    private var dlSpeed = 0L

    fun updateDownloadSpeed(speed: Long) {
        dlSpeed = speed
    }

    fun getStartupBufferLimit(): Long {
        return bufferPolicy.getStartupBufferSize(dlSpeed)
    }

    fun getRollingBufferLimit(): Long {
        return bufferPolicy.getRollingBufferSize(dlSpeed)
    }
}
