package com.ucplayer.app.core.stream.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0002\u0010\u001bJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u000fH\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u000fH\u00c6\u0003J\t\u00109\u001a\u00020\u0013H\u00c6\u0003J\t\u0010:\u001a\u00020\u0015H\u00c6\u0003J\t\u0010;\u001a\u00020\u0017H\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0007H\u00c6\u0003J\t\u0010@\u001a\u00020\u0007H\u00c6\u0003J\t\u0010A\u001a\u00020\u0007H\u00c6\u0003J\t\u0010B\u001a\u00020\u0007H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u00b9\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u00c6\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010I\u001a\u00020\u0007H\u00d6\u0001J\t\u0010J\u001a\u00020KH\u00d6\u0001R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001d\u00a8\u0006L"}, d2 = {"Lcom/ucplayer/app/core/stream/models/StreamStatistics;", "", "speed", "", "downloadRate", "uploadRate", "peers", "", "activeConnections", "seeders", "leechers", "downloaded", "uploaded", "ETA", "progress", "", "cacheSize", "cachePercent", "bufferSeconds", "", "schedulerMode", "Lcom/ucplayer/app/core/stream/models/SchedulerMode;", "streamState", "Lcom/ucplayer/app/core/stream/models/StreamState;", "pieceCompletion", "", "Lcom/ucplayer/app/core/stream/models/PieceState;", "(JJJIIIIJJJFJFDLcom/ucplayer/app/core/stream/models/SchedulerMode;Lcom/ucplayer/app/core/stream/models/StreamState;Ljava/util/List;)V", "getETA", "()J", "getActiveConnections", "()I", "getBufferSeconds", "()D", "getCachePercent", "()F", "getCacheSize", "getDownloadRate", "getDownloaded", "getLeechers", "getPeers", "getPieceCompletion", "()Ljava/util/List;", "getProgress", "getSchedulerMode", "()Lcom/ucplayer/app/core/stream/models/SchedulerMode;", "getSeeders", "getSpeed", "getStreamState", "()Lcom/ucplayer/app/core/stream/models/StreamState;", "getUploadRate", "getUploaded", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class StreamStatistics {
    private final long speed = 0L;
    private final long downloadRate = 0L;
    private final long uploadRate = 0L;
    private final int peers = 0;
    private final int activeConnections = 0;
    private final int seeders = 0;
    private final int leechers = 0;
    private final long downloaded = 0L;
    private final long uploaded = 0L;
    private final long ETA = 0L;
    private final float progress = 0.0F;
    private final long cacheSize = 0L;
    private final float cachePercent = 0.0F;
    private final double bufferSeconds = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.models.SchedulerMode schedulerMode = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.models.StreamState streamState = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.ucplayer.app.core.stream.models.PieceState> pieceCompletion = null;
    
    public StreamStatistics(long speed, long downloadRate, long uploadRate, int peers, int activeConnections, int seeders, int leechers, long downloaded, long uploaded, long ETA, float progress, long cacheSize, float cachePercent, double bufferSeconds, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode schedulerMode, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.StreamState streamState, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ucplayer.app.core.stream.models.PieceState> pieceCompletion) {
        super();
    }
    
    public final long getSpeed() {
        return 0L;
    }
    
    public final long getDownloadRate() {
        return 0L;
    }
    
    public final long getUploadRate() {
        return 0L;
    }
    
    public final int getPeers() {
        return 0;
    }
    
    public final int getActiveConnections() {
        return 0;
    }
    
    public final int getSeeders() {
        return 0;
    }
    
    public final int getLeechers() {
        return 0;
    }
    
    public final long getDownloaded() {
        return 0L;
    }
    
    public final long getUploaded() {
        return 0L;
    }
    
    public final long getETA() {
        return 0L;
    }
    
    public final float getProgress() {
        return 0.0F;
    }
    
    public final long getCacheSize() {
        return 0L;
    }
    
    public final float getCachePercent() {
        return 0.0F;
    }
    
    public final double getBufferSeconds() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.models.SchedulerMode getSchedulerMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.models.StreamState getStreamState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ucplayer.app.core.stream.models.PieceState> getPieceCompletion() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final float component11() {
        return 0.0F;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final float component13() {
        return 0.0F;
    }
    
    public final double component14() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.models.SchedulerMode component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.models.StreamState component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ucplayer.app.core.stream.models.PieceState> component17() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final long component8() {
        return 0L;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.models.StreamStatistics copy(long speed, long downloadRate, long uploadRate, int peers, int activeConnections, int seeders, int leechers, long downloaded, long uploaded, long ETA, float progress, long cacheSize, float cachePercent, double bufferSeconds, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode schedulerMode, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.StreamState streamState, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ucplayer.app.core.stream.models.PieceState> pieceCompletion) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}