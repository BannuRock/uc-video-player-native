package com.ucplayer.app.core.stream.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/ucplayer/app/core/stream/models/StreamState;", "", "(Ljava/lang/String;I)V", "CREATED", "PREPARING", "BUFFERING", "PLAYING", "PAUSED", "DOWNLOADING", "COMPLETED", "FAILED", "CLOSED", "app_debug"})
public enum StreamState {
    /*public static final*/ CREATED /* = new CREATED() */,
    /*public static final*/ PREPARING /* = new PREPARING() */,
    /*public static final*/ BUFFERING /* = new BUFFERING() */,
    /*public static final*/ PLAYING /* = new PLAYING() */,
    /*public static final*/ PAUSED /* = new PAUSED() */,
    /*public static final*/ DOWNLOADING /* = new DOWNLOADING() */,
    /*public static final*/ COMPLETED /* = new COMPLETED() */,
    /*public static final*/ FAILED /* = new FAILED() */,
    /*public static final*/ CLOSED /* = new CLOSED() */;
    
    StreamState() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.ucplayer.app.core.stream.models.StreamState> getEntries() {
        return null;
    }
}