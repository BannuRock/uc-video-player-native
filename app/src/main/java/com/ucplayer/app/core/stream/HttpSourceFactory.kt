package com.ucplayer.app.core.stream

import com.ucplayer.app.core.network.NetworkClient

class HttpSourceFactory(
    private val networkClient: NetworkClient
) : ByteSourceFactory {
    override fun canHandle(url: String): Boolean {
        return url.startsWith("http://", ignoreCase = true) || url.startsWith("https://", ignoreCase = true)
    }

    override fun createByteSource(url: String, sessionId: String): ByteSource {
        return HttpByteSource(networkClient, url)
    }

    override fun createMetadataProvider(byteSource: ByteSource, url: String): MediaMetadataProvider {
        return HttpMetadataProvider(byteSource as HttpByteSource, url)
    }
}
