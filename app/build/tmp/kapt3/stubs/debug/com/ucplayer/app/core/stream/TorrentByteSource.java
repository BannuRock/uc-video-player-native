package com.ucplayer.app.core.stream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@\u00a2\u0006\u0002\u0010\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000bH\u0002J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#J\b\u0010$\u001a\u0004\u0018\u00010\u0018J\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\u001dH\u0096@\u00a2\u0006\u0002\u0010\u001eJ&\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010/J\u001e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u00103R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/ucplayer/app/core/stream/TorrentByteSource;", "Lcom/ucplayer/app/core/stream/ByteSource;", "context", "Landroid/content/Context;", "torrentEngine", "Lcom/ucplayer/app/core/torrent/TorrentEngine;", "magnetUrl", "", "sessionId", "(Landroid/content/Context;Lcom/ucplayer/app/core/torrent/TorrentEngine;Ljava/lang/String;Ljava/lang/String;)V", "activeChannelFile", "Ljava/io/File;", "activeFileChannel", "Ljava/nio/channels/FileChannel;", "fileIndex", "", "firstPieceLogged", "", "pieceLength", "", "resolvedInfoHash", "scheduler", "Lcom/ucplayer/app/core/torrent/PieceScheduler;", "torrentHandle", "Lcom/frostwire/jlibtorrent/TorrentHandle;", "videoFile", "videoFileOffset", "videoFileSize", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findHandle", "getOrOpenFileChannel", "targetFile", "getTorrentFilesList", "", "getTorrentHandle", "getVideoFileSize", "prepare", "read", "offset", "buffer", "", "length", "(J[BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectFileInternal", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileIndex", "waitForPieces", "byteOffset", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TorrentByteSource implements com.ucplayer.app.core.stream.ByteSource {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.torrent.TorrentEngine torrentEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String magnetUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.Nullable()
    private com.frostwire.jlibtorrent.TorrentHandle torrentHandle;
    @org.jetbrains.annotations.Nullable()
    private com.ucplayer.app.core.torrent.PieceScheduler scheduler;
    @org.jetbrains.annotations.Nullable()
    private java.io.File videoFile;
    private long pieceLength = 262144L;
    private long videoFileOffset = 0L;
    private long videoFileSize = 0L;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String resolvedInfoHash;
    private int fileIndex = -1;
    private boolean firstPieceLogged = false;
    @org.jetbrains.annotations.Nullable()
    private java.nio.channels.FileChannel activeFileChannel;
    @org.jetbrains.annotations.Nullable()
    private java.io.File activeChannelFile;
    
    public TorrentByteSource(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.torrent.TorrentEngine torrentEngine, @org.jetbrains.annotations.NotNull()
    java.lang.String magnetUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.frostwire.jlibtorrent.TorrentHandle getTorrentHandle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setFileIndex(int index, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final long getVideoFileSize() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTorrentFilesList() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object prepare(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.nio.channels.FileChannel getOrOpenFileChannel(java.io.File targetFile) {
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
    
    private final com.frostwire.jlibtorrent.TorrentHandle findHandle() {
        return null;
    }
    
    private final java.lang.Object selectFileInternal(int index, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object waitForPieces(long byteOffset, int length, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}