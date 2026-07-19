package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&R\u0012\u0010\u0005\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/ucplayer/app/core/stream/StreamSession;", "", "sessionId", "", "(Ljava/lang/String;)V", "provider", "Lcom/ucplayer/app/core/stream/StreamProvider;", "getProvider", "()Lcom/ucplayer/app/core/stream/StreamProvider;", "getSessionId", "()Ljava/lang/String;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ucplayer/app/core/stream/models/StreamState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "statistics", "Lcom/ucplayer/app/core/stream/models/StreamStatistics;", "getStatistics", "setSchedulerMode", "", "mode", "Lcom/ucplayer/app/core/stream/models/SchedulerMode;", "app_debug"})
public abstract class StreamSession {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sessionId = null;
    
    public StreamSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSessionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ucplayer.app.core.stream.StreamProvider getProvider();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.core.stream.models.StreamState> getState();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.core.stream.models.StreamStatistics> getStatistics();
    
    public abstract void setSchedulerMode(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode mode);
}