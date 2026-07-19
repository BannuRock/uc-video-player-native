package com.ucplayer.app.core.stream.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/ucplayer/app/core/stream/models/SessionState;", "", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", "METADATA_READY", "BUFFERING", "READY", "PLAYING", "SEEKING", "PAUSED", "COMPLETED", "ERROR", "CLOSED", "app_debug"})
public enum SessionState {
    /*public static final*/ IDLE /* = new IDLE() */,
    /*public static final*/ PREPARING /* = new PREPARING() */,
    /*public static final*/ METADATA_READY /* = new METADATA_READY() */,
    /*public static final*/ BUFFERING /* = new BUFFERING() */,
    /*public static final*/ READY /* = new READY() */,
    /*public static final*/ PLAYING /* = new PLAYING() */,
    /*public static final*/ SEEKING /* = new SEEKING() */,
    /*public static final*/ PAUSED /* = new PAUSED() */,
    /*public static final*/ COMPLETED /* = new COMPLETED() */,
    /*public static final*/ ERROR /* = new ERROR() */,
    /*public static final*/ CLOSED /* = new CLOSED() */;
    
    SessionState() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.ucplayer.app.core.stream.models.SessionState> getEntries() {
        return null;
    }
}