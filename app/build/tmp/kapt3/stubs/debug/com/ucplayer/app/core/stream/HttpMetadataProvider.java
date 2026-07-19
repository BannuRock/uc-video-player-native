package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/ucplayer/app/core/stream/HttpMetadataProvider;", "Lcom/ucplayer/app/core/stream/MediaMetadataProvider;", "byteSource", "Lcom/ucplayer/app/core/stream/HttpByteSource;", "url", "", "(Lcom/ucplayer/app/core/stream/HttpByteSource;Ljava/lang/String;)V", "mediaInfo", "Lcom/ucplayer/app/core/stream/models/MediaInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class HttpMetadataProvider implements com.ucplayer.app.core.stream.MediaMetadataProvider {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.HttpByteSource byteSource = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    
    public HttpMetadataProvider(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.HttpByteSource byteSource, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object mediaInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ucplayer.app.core.stream.models.MediaInfo> $completion) {
        return null;
    }
}