package com.ucplayer.app.feature.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/ucplayer/app/feature/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "pluginManager", "Lcom/ucplayer/app/core/parser/PluginManager;", "historyRepository", "Lcom/ucplayer/app/core/database/HistoryRepository;", "(Lcom/ucplayer/app/core/parser/PluginManager;Lcom/ucplayer/app/core/database/HistoryRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ucplayer/app/feature/home/HomeUiState;", "historyList", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/ucplayer/app/core/database/HistoryEntry;", "getHistoryList", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "clearHistory", "", "deleteHistoryEntry", "entry", "resetState", "scrapeUrl", "url", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.parser.PluginManager pluginManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ucplayer.app.core.database.HistoryRepository historyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ucplayer.app.feature.home.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.feature.home.HomeUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ucplayer.app.core.database.HistoryEntry>> historyList = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.parser.PluginManager pluginManager, @org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.database.HistoryRepository historyRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ucplayer.app.feature.home.HomeUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ucplayer.app.core.database.HistoryEntry>> getHistoryList() {
        return null;
    }
    
    public final void scrapeUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public final void clearHistory() {
    }
    
    public final void deleteHistoryEntry(@org.jetbrains.annotations.NotNull()
    com.ucplayer.app.core.database.HistoryEntry entry) {
    }
    
    public final void resetState() {
    }
}