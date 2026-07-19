package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/ucplayer/app/core/stream/ByteSourceFactory;", "", "canHandle", "", "url", "", "createByteSource", "Lcom/ucplayer/app/core/stream/ByteSource;", "sessionId", "createMetadataProvider", "Lcom/ucplayer/app/core/stream/MediaMetadataProvider;", "byteSource", "app_debug"})
public abstract interface ByteSourceFactory {
    
    public abstract boolean canHandle(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ucplayer.app.core.stream.ByteSource createByteSource(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ucplayer.app.core.stream.MediaMetadataProvider createMetadataProvider(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.ByteSource byteSource, @org.jetbrains.annotations.NotNull()
    java.lang.String url);
}