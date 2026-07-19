package com.ucplayer.app.plugins.tamilmv;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/ucplayer/app/plugins/tamilmv/TamilMvParser;", "Lcom/ucplayer/app/core/parser/ParserPlugin;", "networkClient", "Lcom/ucplayer/app/core/network/NetworkClient;", "(Lcom/ucplayer/app/core/network/NetworkClient;)V", "canHandle", "", "url", "", "extract", "Lcom/ucplayer/app/models/VideoInfo;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMagnetName", "magnetUrl", "resolveUrl", "baseUrl", "relativeUrl", "app_debug"})
public final class TamilMvParser implements com.ucplayer.app.core.parser.ParserPlugin {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.network.NetworkClient networkClient = null;
    
    @javax.inject.Inject()
    public TamilMvParser(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.network.NetworkClient networkClient) {
        super();
    }
    
    @java.lang.Override()
    public boolean canHandle(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object extract(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ucplayer.app.models.VideoInfo> $completion) {
        return null;
    }
    
    private final java.lang.String getMagnetName(java.lang.String magnetUrl) {
        return null;
    }
    
    private final java.lang.String resolveUrl(java.lang.String baseUrl, java.lang.String relativeUrl) {
        return null;
    }
}