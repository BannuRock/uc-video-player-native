package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/ucplayer/app/core/stream/RequestPipeline;", "", "byteSource", "Lcom/ucplayer/app/core/stream/ByteSource;", "(Lcom/ucplayer/app/core/stream/ByteSource;)V", "readCount", "", "cancelActiveRequests", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "offset", "", "buffer", "", "length", "(J[BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RequestPipeline {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.ByteSource byteSource = null;
    private int readCount = 0;
    
    public RequestPipeline(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.ByteSource byteSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object read(long offset, @org.jetbrains.annotations.NotNull()
    byte[] buffer, int length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cancelActiveRequests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}