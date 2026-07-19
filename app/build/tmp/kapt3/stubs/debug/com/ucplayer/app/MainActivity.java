package com.ucplayer.app;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020(H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/ucplayer/app/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "cacheManager", "Lcom/ucplayer/app/core/cache/CacheManager;", "getCacheManager", "()Lcom/ucplayer/app/core/cache/CacheManager;", "setCacheManager", "(Lcom/ucplayer/app/core/cache/CacheManager;)V", "homeViewModel", "Lcom/ucplayer/app/feature/home/HomeViewModel;", "getHomeViewModel", "()Lcom/ucplayer/app/feature/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "loopbackServer", "Lcom/ucplayer/app/core/stream/LoopbackServer;", "getLoopbackServer", "()Lcom/ucplayer/app/core/stream/LoopbackServer;", "setLoopbackServer", "(Lcom/ucplayer/app/core/stream/LoopbackServer;)V", "networkClient", "Lcom/ucplayer/app/core/network/NetworkClient;", "getNetworkClient", "()Lcom/ucplayer/app/core/network/NetworkClient;", "setNetworkClient", "(Lcom/ucplayer/app/core/network/NetworkClient;)V", "sessionManager", "Lcom/ucplayer/app/core/stream/SessionManager;", "getSessionManager", "()Lcom/ucplayer/app/core/stream/SessionManager;", "setSessionManager", "(Lcom/ucplayer/app/core/stream/SessionManager;)V", "torrentEngine", "Lcom/ucplayer/app/core/torrent/TorrentEngine;", "getTorrentEngine", "()Lcom/ucplayer/app/core/torrent/TorrentEngine;", "setTorrentEngine", "(Lcom/ucplayer/app/core/torrent/TorrentEngine;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy homeViewModel$delegate = null;
    @javax.inject.Inject()
    public com.ucplayer.app.core.cache.CacheManager cacheManager;
    @javax.inject.Inject()
    public com.ucplayer.app.core.network.NetworkClient networkClient;
    @javax.inject.Inject()
    public com.ucplayer.app.core.stream.LoopbackServer loopbackServer;
    @javax.inject.Inject()
    public com.ucplayer.app.core.stream.SessionManager sessionManager;
    @javax.inject.Inject()
    public com.ucplayer.app.core.torrent.TorrentEngine torrentEngine;
    
    public MainActivity() {
        super();
    }
    
    private final com.ucplayer.app.feature.home.HomeViewModel getHomeViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.cache.CacheManager getCacheManager() {
        return null;
    }
    
    public final void setCacheManager(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.cache.CacheManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.network.NetworkClient getNetworkClient() {
        return null;
    }
    
    public final void setNetworkClient(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.network.NetworkClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.LoopbackServer getLoopbackServer() {
        return null;
    }
    
    public final void setLoopbackServer(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.LoopbackServer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.SessionManager getSessionManager() {
        return null;
    }
    
    public final void setSessionManager(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.SessionManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.torrent.TorrentEngine getTorrentEngine() {
        return null;
    }
    
    public final void setTorrentEngine(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.torrent.TorrentEngine p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}