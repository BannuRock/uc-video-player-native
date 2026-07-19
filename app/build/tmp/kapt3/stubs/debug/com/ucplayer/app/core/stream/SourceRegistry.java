package com.ucplayer.app.core.stream;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/ucplayer/app/core/stream/SourceRegistry;", "", "context", "Landroid/content/Context;", "torrentEngine", "Lcom/ucplayer/app/core/torrent/TorrentEngine;", "networkClient", "Lcom/ucplayer/app/core/network/NetworkClient;", "(Landroid/content/Context;Lcom/ucplayer/app/core/torrent/TorrentEngine;Lcom/ucplayer/app/core/network/NetworkClient;)V", "factories", "", "Lcom/ucplayer/app/core/stream/ByteSourceFactory;", "getFactory", "url", "", "registerFactory", "", "factory", "app_debug"})
public final class SourceRegistry {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.torrent.TorrentEngine torrentEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.network.NetworkClient networkClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.ucplayer.app.core.stream.ByteSourceFactory> factories = null;
    
    @javax.inject.Inject()
    public SourceRegistry(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.torrent.TorrentEngine torrentEngine, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.network.NetworkClient networkClient) {
        super();
    }
    
    public final void registerFactory(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.ByteSourceFactory factory) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.ByteSourceFactory getFactory(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
}