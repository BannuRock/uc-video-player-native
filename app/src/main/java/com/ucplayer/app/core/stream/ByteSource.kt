package com.ucplayer.app.core.stream

interface ByteSource {
    suspend fun prepare()
    suspend fun read(offset: Long, buffer: ByteArray, length: Int): Int
    suspend fun close()
}
