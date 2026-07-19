package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/ucplayer/app/core/stream/BufferPolicy;", "", "()V", "getRollingBufferSize", "", "dlSpeedBytesPerSec", "getStartupBufferSize", "app_debug"})
public final class BufferPolicy {
    
    public BufferPolicy() {
        super();
    }
    
    public final long getStartupBufferSize(long dlSpeedBytesPerSec) {
        return 0L;
    }
    
    public final long getRollingBufferSize(long dlSpeedBytesPerSec) {
        return 0L;
    }
}