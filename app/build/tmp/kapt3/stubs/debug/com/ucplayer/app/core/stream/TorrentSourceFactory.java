package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/ucplayer/app/core/stream/TorrentSourceFactory;", "Lcom/ucplayer/app/core/stream/ByteSourceFactory;", "context", "Landroid/content/Context;", "torrentEngine", "Lcom/ucplayer/app/core/torrent/TorrentEngine;", "(Landroid/content/Context;Lcom/ucplayer/app/core/torrent/TorrentEngine;)V", "canHandle", "", "url", "", "createByteSource", "Lcom/ucplayer/app/core/stream/ByteSource;", "sessionId", "createMetadataProvider", "Lcom/ucplayer/app/core/stream/MediaMetadataProvider;", "byteSource", "app_debug"})
public final class TorrentSourceFactory implements com.ucplayer.app.core.stream.ByteSourceFactory {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.torrent.TorrentEngine torrentEngine = null;
    
    public TorrentSourceFactory(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.torrent.TorrentEngine torrentEngine) {
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