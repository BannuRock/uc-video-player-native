package com.ucplayer.app.core.stream

import android.util.Log

object TelemetryEngine {
    fun reportTorrentStats(
        hash: String,
        state: String,
        peers: Int,
        seeds: Int,
        downloadRateKb: Float,
        trackers: String,
        requestedPieces: List<Int>
    ) {
        Log.e("PlaybackTracker", 
            "Torrent Telemetry -> " +
            "Hash: $hash | " +
            "State: $state | " +
            "Peers: $peers | " +
            "Seeds: $seeds | " +
            "DL Speed: ${String.format(java.util.Locale.US, "%.1f", downloadRateKb)} KB/s | " +
            "Active Requests: $requestedPieces | " +
            "Trackers: $trackers"
        )
    }

    fun reportHttpStats(
        url: String,
        bytesRead: Long,
        speedKb: Float,
        latencyMs: Long
    ) {
        Log.e("PlaybackTracker",
            "HTTP Telemetry -> " +
            "URL: $url | " +
            "Bytes Read: $bytesRead | " +
            "Speed: ${String.format(java.util.Locale.US, "%.1f", speedKb)} KB/s | " +
            "Latency: ${latencyMs}ms"
        )
    }
}
