package com.ucplayer.app.core.cache;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/ucplayer/app/core/cache/CacheManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCache", "Landroidx/media3/datasource/cache/SimpleCache;", "getMediaCache", "()Landroidx/media3/datasource/cache/SimpleCache;", "clearCache", "", "getCacheDir", "Ljava/io/File;", "app_debug"})
public final class CacheManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.datasource.cache.SimpleCache mediaCache = null;
    
    @javax.inject.Inject()
    public CacheManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.datasource.cache.SimpleCache getMediaCache() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getCacheDir() {
        return null;
    }
    
    public final void clearCache() {
    }
}