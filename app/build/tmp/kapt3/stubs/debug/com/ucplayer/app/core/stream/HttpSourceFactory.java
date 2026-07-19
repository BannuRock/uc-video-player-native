package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/ucplayer/app/core/stream/HttpSourceFactory;", "Lcom/ucplayer/app/core/stream/ByteSourceFactory;", "networkClient", "Lcom/ucplayer/app/core/network/NetworkClient;", "(Lcom/ucplayer/app/core/network/NetworkClient;)V", "canHandle", "", "url", "", "createByteSource", "Lcom/ucplayer/app/core/stream/ByteSource;", "sessionId", "createMetadataProvider", "Lcom/ucplayer/app/core/stream/MediaMetadataProvider;", "byteSource", "app_debug"})
public final class HttpSourceFactory implements com.ucplayer.app.core.stream.ByteSourceFactory {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.network.NetworkClient networkClient = null;
    
    public HttpSourceFactory(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.network.NetworkClient networkClient) {
        super();
    }
    
    @java.lang.Override()
    public boolean canHandle(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ucplayer.app.core.stream.ByteSource createByteSource(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ucplayer.app.core.stream.MediaMetadataProvider createMetadataProvider(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.ByteSource byteSource, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
}