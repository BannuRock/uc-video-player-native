package com.ucplayer.app.core.stream;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/ucplayer/app/core/stream/LoopbackServer;", "", "sessionManager", "Lcom/ucplayer/app/core/stream/SessionManager;", "(Lcom/ucplayer/app/core/stream/SessionManager;)V", "activePort", "", "isRunning", "", "serverScope", "Lkotlinx/coroutines/CoroutineScope;", "serverSocket", "Ljava/net/ServerSocket;", "getPort", "handleClient", "", "client", "Ljava/net/Socket;", "(Ljava/net/Socket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBadRequest", "output", "Ljava/io/OutputStream;", "sendInternalServerError", "sendNotFound", "sendRangeNotSatisfiable", "fileSize", "", "start", "stop", "app_debug"})
public final class LoopbackServer {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.stream.SessionManager sessionManager = null;
    @org.jetbrains.annotations.Nullable()
    private java.net.ServerSocket serverSocket;
    private boolean isRunning = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serverScope = null;
    private int activePort = 0;
    
    @javax.inject.Inject()
    public LoopbackServer(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.SessionManager sessionManager) {
        super();
    }
    
    public final int start() {
        return 0;
    }
    
    public final void stop() {
    }
    
    public final int getPort() {
        return 0;
    }
    
    private final java.lang.Object handleClient(java.net.Socket client, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void sendBadRequest(java.io.OutputStream output) {
    }
    
    private final void sendNotFound(java.io.OutputStream output) {
    }
    
    private final void sendInternalServerError(java.io.OutputStream output) {
    }
    
    private final void sendRangeNotSatisfiable(java.io.OutputStream output, long fileSize) {
    }
}