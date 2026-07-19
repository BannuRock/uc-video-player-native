package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/ucplayer/app/core/stream/EngineConfig;", "", "()V", "diskCacheLimitBytes", "", "getDiskCacheLimitBytes", "()J", "setDiskCacheLimitBytes", "(J)V", "memoryCacheLimitBytes", "getMemoryCacheLimitBytes", "setMemoryCacheLimitBytes", "requestTimeoutMs", "getRequestTimeoutMs", "setRequestTimeoutMs", "rollingBufferBytes", "getRollingBufferBytes", "setRollingBufferBytes", "startupBufferBytes", "getStartupBufferBytes", "setStartupBufferBytes", "app_debug"})
public final class EngineConfig {
    private static long startupBufferBytes = 33554432L;
    private static long rollingBufferBytes = 268435456L;
    private static long memoryCacheLimitBytes = 67108864L;
    private static long diskCacheLimitBytes = 536870912L;
    private static long requestTimeoutMs = 10000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.ucplayer.app.core.stream.EngineConfig INSTANCE = null;
    
    private EngineConfig() {
        super();
    }
    
    public final long getStartupBufferBytes() {
        return 0L;
    }
    
    public final void setStartupBufferBytes(long p0) {
    }
    
    public final long getRollingBufferBytes() {
        return 0L;
    }
    
    public final void setRollingBufferBytes(long p0) {
    }
    
    public final long getMemoryCacheLimitBytes() {
        return 0L;
    }
    
    public final void setMemoryCacheLimitBytes(long p0) {
    }
    
    public final long getDiskCacheLimitBytes() {
        return 0L;
    }
    
    public final void setDiskCacheLimitBytes(long p0) {
    }
    
    public final long getRequestTimeoutMs() {
        return 0L;
    }
    
    public final void setRequestTimeoutMs(long p0) {
    }
}