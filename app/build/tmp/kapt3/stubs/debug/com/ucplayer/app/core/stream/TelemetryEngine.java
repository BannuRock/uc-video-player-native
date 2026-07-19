package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJD\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/ucplayer/app/core/stream/TelemetryEngine;", "", "()V", "reportHttpStats", "", "url", "", "bytesRead", "", "speedKb", "", "latencyMs", "reportTorrentStats", "hash", "state", "peers", "", "seeds", "downloadRateKb", "trackers", "requestedPieces", "", "app_debug"})
public final class TelemetryEngine {
    @org.jetbrains.annotations.NotNull()
    public static final com.ucplayer.app.core.stream.TelemetryEngine INSTANCE = null;
    
    private TelemetryEngine() {
        super();
    }
    
    public final void reportTorrentStats(@org.jetbrains.annotations.NotNull()
    java.lang.String hash, @org.jetbrains.annotations.NotNull()
    java.lang.String state, int peers, int seeds, float downloadRateKb, @org.jetbrains.annotations.NotNull()
    java.lang.String trackers, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> requestedPieces) {
    }
    
    public final void reportHttpStats(@org.jetbrains.annotations.NotNull()
    java.lang.String url, long bytesRead, float speedKb, long latencyMs) {
    }
}