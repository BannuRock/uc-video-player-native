package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u000e\u0010\u0013\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u00a6@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006$"}, d2 = {"Lcom/ucplayer/app/core/stream/StreamProvider;", "", "metadata", "Lcom/ucplayer/app/core/stream/models/MediaMetadata;", "getMetadata", "()Lcom/ucplayer/app/core/stream/models/MediaMetadata;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPieceStates", "", "Lcom/ucplayer/app/core/stream/models/PieceState;", "getStatistics", "Lcom/ucplayer/app/core/stream/models/StreamStatistics;", "getTorrentFiles", "open", "prepare", "read", "", "offset", "output", "Ljava/io/OutputStream;", "length", "(JLjava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectFile", "fileIndex", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSchedulerMode", "mode", "Lcom/ucplayer/app/core/stream/models/SchedulerMode;", "stop", "app_debug"})
public abstract interface StreamProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getSessionId();
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.ucplayer.app.core.stream.models.MediaMetadata getMetadata();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object prepare(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object open(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object read(long offset, @org.jetbrains.annotations.NotNull()
    java.io.OutputStream output, long length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object stop(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object close(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.ucplayer.app.core.stream.models.PieceState> getPieceStates();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ucplayer.app.core.stream.models.StreamStatistics getStatistics();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object selectFile(int fileIndex, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getTorrentFiles();
    
    public abstract void setSchedulerMode(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode mode);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object selectFile(@org.jetbrains.annotations.NotNull()
        com.ucplayer.app.core.stream.StreamProvider $this, int fileIndex, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static java.util.List<java.lang.String> getTorrentFiles(@org.jetbrains.annotations.NotNull()
        com.ucplayer.app.core.stream.StreamProvider $this) {
            return null;
        }
        
        public static void setSchedulerMode(@org.jetbrains.annotations.NotNull()
        com.ucplayer.app.core.stream.StreamProvider $this, @org.jetbrains.annotations.NotNull()
        com.ucplayer.app.core.stream.models.SchedulerMode mode) {
        }
    }
}