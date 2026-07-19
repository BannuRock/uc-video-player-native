package com.ucplayer.app.feature.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0007\u001aB\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u001520\u0010\u0016\u001a,\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\n0\u0017H\u0007\u001aP\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d20\u0010\u0016\u001a,\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\n0\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0007\u001a\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0007\u001a\u001e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0007\"\u0013\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0013\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u00a8\u0006&"}, d2 = {"BackgroundDark", "Landroidx/compose/ui/graphics/Color;", "getBackgroundDark", "()J", "J", "CardGray", "getCardGray", "PrimaryOrange", "getPrimaryOrange", "HistorySection", "", "historyList", "", "Lcom/ucplayer/app/core/database/HistoryEntry;", "onEntryClick", "Lkotlin/Function1;", "onDeleteClick", "onClearAllClick", "Lkotlin/Function0;", "HomeScreen", "viewModel", "Lcom/ucplayer/app/feature/home/HomeViewModel;", "onPlayVideo", "Lkotlin/Function4;", "", "", "", "SuccessResults", "info", "Lcom/ucplayer/app/models/VideoInfo;", "onBack", "TorrentItem", "torrent", "Lcom/ucplayer/app/models/TorrentSource;", "onPlayClick", "VideoItem", "video", "Lcom/ucplayer/app/models/VideoSource;", "app_debug"})
public final class HomeScreenKt {
    private static final long PrimaryOrange = 0L;
    private static final long BackgroundDark = 0L;
    private static final long CardGray = 0L;
    
    public static final long getPrimaryOrange() {
        return 0L;
    }
    
    public static final long getBackgroundDark() {
        return 0L;
    }
    
    public static final long getCardGray() {
        return 0L;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.feature.home.HomeViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super java.util.Map<java.lang.String, java.lang.String>, ? super java.lang.Boolean, kotlin.Unit> onPlayVideo) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HistorySection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ucplayer.app.core.database.HistoryEntry> historyList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ucplayer.app.core.database.HistoryEntry, kotlin.Unit> onEntryClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ucplayer.app.core.database.HistoryEntry, kotlin.Unit> onDeleteClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearAllClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SuccessResults(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.models.VideoInfo info, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super java.util.Map<java.lang.String, java.lang.String>, ? super java.lang.Boolean, kotlin.Unit> onPlayVideo, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void VideoItem(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.models.VideoSource video, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPlayClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TorrentItem(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.models.TorrentSource torrent, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPlayClick) {
    }
}