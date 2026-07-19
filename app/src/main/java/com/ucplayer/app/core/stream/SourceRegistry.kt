package com.ucplayer.app.core.stream

import android.content.Context
import com.ucplayer.app.core.network.NetworkClient
import com.ucplayer.app.core.torrent.TorrentEngine
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SourceRegistry @Inject constructor(
    @ApplicationContext private val context: Context,
    private val torrentEngine: TorrentEngine,
    private val networkClient: NetworkClient
) {
    private val factories = mutableListOf<ByteSourceFactory>()

    init {
        registerFactory(TorrentSourceFactory(context, torrentEngine))
        registerFactory(HttpSourceFactory(networkClient))
    }

    fun registerFactory(factory: ByteSourceFactory) {
        factories.add(factory)
    }

    fun getFactory(url: String): ByteSourceFactory {
        return factories.find { it.canHandle(url) }
            ?: throw UnsupportedOperationException("No registered factory can handle URI: $url")
    }
}
