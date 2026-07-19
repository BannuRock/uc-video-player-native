package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/ucplayer/app/core/stream/GenericStreamSession;", "Lcom/ucplayer/app/core/stream/StreamSession;", "provider", "Lcom/ucplayer/app/core/stream/StreamProvider;", "sessionId", "", "(Lcom/ucplayer/app/core/stream/StreamProvider;Ljava/lang/String;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ucplayer/app/core/stream/models/StreamState;", "_statistics", "Lcom/ucplayer/app/core/stream/models/StreamStatistics;", "getProvider", "()Lcom/ucplayer/app/core/stream/StreamProvider;", "sessionScope", "Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "statistics", "getStatistics", "setSchedulerMode", "", "mode", "Lcom/ucplayer/app/core/stream/models/SchedulerMode;", "app_debug"})
public final class GenericStreamSession extends com.ucplayer.app.core.stream.StreamSession {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.StreamProvider provider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ucplayer.app.core.stream.models.StreamState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.core.stream.models.StreamState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ucplayer.app.core.stream.models.StreamStatistics> _statistics = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.core.stream.models.StreamStatistics> statistics = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope sessionScope = null;
    
    public GenericStreamSession(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.StreamProvider provider, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ucplayer.app.core.stream.StreamProvider getProvider() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.core.stream.models.StreamState> getState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.core.stream.models.StreamStatistics> getStatistics() {
        return null;
    }
    
    @java.lang.Override()
    public void setSchedulerMode(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode mode) {
    }
}