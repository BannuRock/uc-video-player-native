package com.ucplayer.app.core.stream

import android.util.Log

object PlaybackTracker {
    private var startTime: Long = 0L

    fun start() {
        startTime = System.currentTimeMillis()
        Log.e("PlaybackTracker", "Play Click: 0 ms")
    }

    fun log(stage: String) {
        val elapsed = if (startTime == 0L) 0L else System.currentTimeMillis() - startTime
        Log.e("PlaybackTracker", "$stage: $elapsed ms")
    }
}
