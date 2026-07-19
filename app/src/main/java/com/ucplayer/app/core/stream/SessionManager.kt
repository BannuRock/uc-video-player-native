package com.ucplayer.app.core.stream

import android.content.Context
import com.ucplayer.app.core.torrent.TorrentEngine
import com.ucplayer.app.core.network.NetworkClient
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    @dagger.hilt.android.qualifiers.ApplicationContext private val context: Context,
    private val torrentEngine: TorrentEngine,
    private val networkClient: NetworkClient,
    private val sourceRegistry: SourceRegistry
) {
    private val activeSessions = ConcurrentHashMap<String, StreamSession>()

    fun getOrCreateTorrentSession(sourceUrl: String, sessionId: String): StreamSession {
        return activeSessions.computeIfAbsent(sessionId) {
            val factory = sourceRegistry.getFactory(sourceUrl)
            val byteSource = factory.createByteSource(sourceUrl, sessionId)
            val metadataProvider = factory.createMetadataProvider(byteSource, sourceUrl)
            val provider = UniversalStreamProvider(sessionId, byteSource, metadataProvider)
            GenericStreamSession(provider, sessionId)
        }
    }

    fun getSession(sessionId: String): StreamSession? {
        return activeSessions[sessionId]
    }

    suspend fun removeSession(sessionId: String) {
        val session = activeSessions.remove(sessionId)
        session?.provider?.close()
    }

    suspend fun clearAll() {
        activeSessions.values.forEach {
            it.provider.close()
        }
        activeSessions.clear()
    }
}
