package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ucplayer/app/core/stream/HttpByteSource;", "Lcom/ucplayer/app/core/stream/ByteSource;", "networkClient", "Lcom/ucplayer/app/core/network/NetworkClient;", "url", "", "(Lcom/ucplayer/app/core/network/NetworkClient;Ljava/lang/String;)V", "size", "", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContentLength", "prepare", "read", "", "offset", "buffer", "", "length", "(J[BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class HttpByteSource implements com.ucplayer.app.core.stream.ByteSource {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.network.NetworkClient networkClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    private long size = -1L;
    
    public HttpByteSource(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.network.NetworkClient networkClient, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object prepare(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object read(long offset, @org.jetbrains.annotations.NotNull()
    byte[] buffer, int length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object close(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final long getContentLength() {
        return 0L;
    }
}