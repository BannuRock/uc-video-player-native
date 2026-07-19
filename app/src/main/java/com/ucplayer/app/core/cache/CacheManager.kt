package com.ucplayer.app.core.cache

import android.content.Context
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    val mediaCache: SimpleCache

    init {
        val cacheDir = File(context.cacheDir, "media_cache")
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
        val databaseProvider = StandaloneDatabaseProvider(context)
        val evictor = LeastRecentlyUsedCacheEvictor(512 * 1024 * 1024) // 512 MB cache limit
        mediaCache = SimpleCache(cacheDir, evictor, databaseProvider)
    }

    fun getCacheDir(): File {
        return File(context.cacheDir, "media_cache")
    }

    fun clearCache() {
        try {
            mediaCache.keys.forEach { key ->
                mediaCache.removeResource(key)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
