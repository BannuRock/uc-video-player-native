package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u000e\u0010 \u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010!\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020#H\u0096@\u00a2\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0096@\u00a2\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/ucplayer/app/core/stream/UniversalStreamProvider;", "Lcom/ucplayer/app/core/stream/StreamProvider;", "sessionId", "", "byteSource", "Lcom/ucplayer/app/core/stream/ByteSource;", "metadataProvider", "Lcom/ucplayer/app/core/stream/MediaMetadataProvider;", "(Ljava/lang/String;Lcom/ucplayer/app/core/stream/ByteSource;Lcom/ucplayer/app/core/stream/MediaMetadataProvider;)V", "firstByteServedLogged", "", "metadata", "Lcom/ucplayer/app/core/stream/models/MediaMetadata;", "getMetadata", "()Lcom/ucplayer/app/core/stream/models/MediaMetadata;", "setMetadata", "(Lcom/ucplayer/app/core/stream/models/MediaMetadata;)V", "requestPipeline", "Lcom/ucplayer/app/core/stream/RequestPipeline;", "getSessionId", "()Ljava/lang/String;", "streamState", "Lcom/ucplayer/app/core/stream/models/StreamState;", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPieceStates", "", "Lcom/ucplayer/app/core/stream/models/PieceState;", "getStatistics", "Lcom/ucplayer/app/core/stream/models/StreamStatistics;", "getTorrentFiles", "open", "prepare", "read", "", "offset", "output", "Ljava/io/OutputStream;", "length", "(JLjava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectFile", "fileIndex", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "app_debug"})
public final class UniversalStreamProvider implements com.ucplayer.app.core.stream.StreamProvider {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.ByteSource byteSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.MediaMetadataProvider metadataProvider = null;
    @org.jetbrains.annotations.Nullable()
    private com.ucplayer.app.core.stream.models.MediaMetadata metadata;
    @org.jetbrains.annotations.NotNull()
    private com.ucplayer.app.core.stream.models.StreamState streamState = com.ucplayer.app.core.stream.models.StreamState.CREATED;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.RequestPipeline requestPipeline = null;
    private boolean firstByteServedLogged = false;
    
    public UniversalStreamProvider(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.ByteSource byteSource, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.MediaMetadataProvider metadataProvider) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getSessionId() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.ucplayer.app.core.stream.models.MediaMetadata getMetadata() {
        return null;
    }
    
    public void setMetadata(@org.jetbrains.annotations.Nullable()
    com.ucplayer.app.core.stream.models.MediaMetadata p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object prepare(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object open(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object read(long offset, @org.jetbrains.annotations.NotNull()
    java.io.OutputStream output, long length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object stop(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object close(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.ucplayer.app.core.stream.models.PieceState> getPieceStates() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ucplayer.app.core.stream.models.StreamStatistics getStatistics() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object selectFile(int fileIndex, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> getTorrentFiles() {
        return null;
    }
    
    @java.lang.Override()
    public void setSchedulerMode(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode mode) {
    }
}