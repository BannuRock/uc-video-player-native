package com.ucplayer.app.core.stream;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0017R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/ucplayer/app/core/stream/SessionManager;", "", "context", "Landroid/content/Context;", "torrentEngine", "Lcom/ucplayer/app/core/torrent/TorrentEngine;", "networkClient", "Lcom/ucplayer/app/core/network/NetworkClient;", "sourceRegistry", "Lcom/ucplayer/app/core/stream/SourceRegistry;", "(Landroid/content/Context;Lcom/ucplayer/app/core/torrent/TorrentEngine;Lcom/ucplayer/app/core/network/NetworkClient;Lcom/ucplayer/app/core/stream/SourceRegistry;)V", "activeSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ucplayer/app/core/stream/StreamSession;", "clearAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateTorrentSession", "sourceUrl", "sessionId", "getSession", "removeSession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.torrent.TorrentEngine torrentEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.network.NetworkClient networkClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.SourceRegistry sourceRegistry = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ucplayer.app.core.stream.StreamSession> activeSessions = null;
    
    @javax.inject.Inject()
    public SessionManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.torrent.TorrentEngine torrentEngine, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.network.NetworkClient networkClient, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.SourceRegistry sourceRegistry) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.StreamSession getOrCreateTorrentSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sourceUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ucplayer.app.core.stream.StreamSession getSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeSession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}