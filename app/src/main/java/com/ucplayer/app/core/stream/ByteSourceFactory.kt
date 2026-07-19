package com.ucplayer.app.core.stream

interface ByteSourceFactory {
    fun canHandle(url: String): Boolean
    fun createByteSource(url: String, sessionId: String): ByteSource
    fun createMetadataProvider(byteSource: ByteSource, url: String): MediaMetadataProvider
}
