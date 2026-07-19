package com.ucplayer.app.core.stream

import android.util.Log

class RequestPipeline(private val byteSource: ByteSource) {
    private var readCount = 0

    suspend fun read(offset: Long, buffer: ByteArray, length: Int): Int {
        readCount++
        val startTime = System.currentTimeMillis()
        val read = byteSource.read(offset, buffer, length)
        val duration = System.currentTimeMillis() - startTime
        
        Log.e("PlaybackTracker", "Read #$readCount | Offset: $offset | Length: $length | Time: ${duration}ms | Returned: $read bytes")
        return read
    }

    suspend fun cancelActiveRequests() {
    }
}
