package com.ucplayer.app.core.torrent;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\bJ0\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ucplayer/app/core/torrent/PieceScheduler;", "", "handle", "Lcom/frostwire/jlibtorrent/TorrentHandle;", "(Lcom/frostwire/jlibtorrent/TorrentHandle;)V", "lastHighStartPiece", "", "mode", "Lcom/ucplayer/app/core/stream/models/SchedulerMode;", "applySchedulingRules", "", "getMode", "prioritizeByteRange", "byteOffset", "", "length", "pieceLength", "fileOffset", "dlSpeedBytesPerSec", "setMode", "newMode", "app_debug"})
public final class PieceScheduler {
    @org.jetbrains.annotations.NotNull()
    private final com.frostwire.jlibtorrent.TorrentHandle handle = null;
    @org.jetbrains.annotations.NotNull()
    private com.ucplayer.app.core.stream.models.SchedulerMode mode = com.ucplayer.app.core.stream.models.SchedulerMode.STREAMING;
    private int lastHighStartPiece = -1;
    
    public PieceScheduler(@org.jetbrains.annotations.NotNull()
    com.frostwire.jlibtorrent.TorrentHandle handle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ucplayer.app.core.stream.models.SchedulerMode getMode() {
        return null;
    }
    
    public final void setMode(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.stream.models.SchedulerMode newMode) {
    }
    
    private final void applySchedulingRules() {
    }
    
    public final void prioritizeByteRange(long byteOffset, int length, long pieceLength, long fileOffset, long dlSpeedBytesPerSec) {
    }
}