package com.ucplayer.app.core.stream

import com.ucplayer.app.core.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Request
import java.io.IOException

class HttpByteSource(
    private val networkClient: NetworkClient,
    private val url: String
) : ByteSource {
    private var size: Long = -1

    override suspend fun prepare() = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url).head().build()
        try {
            networkClient.okHttpClient.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    size = response.header("Content-Length")?.toLongOrNull() ?: -1
                }
            }
        } catch (e: Exception) {
            // Fallback for servers not supporting HEAD
        }
    }

    override suspend fun read(offset: Long, buffer: ByteArray, length: Int): Int = withContext(Dispatchers.IO) {
        val endOffset = offset + length - 1
        val request = Request.Builder()
            .url(url)
            .header("Range", "bytes=$offset-$endOffset")
            .build()

        val startTime = System.currentTimeMillis()
        networkClient.okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("HTTP Range error: ${response.code}")
            val body = response.body ?: throw IOException("Empty HTTP response body")
            val bytes = body.bytes()
            val duration = System.currentTimeMillis() - startTime
            val speedKb = if (duration > 0) (bytes.size / 1024f) / (duration / 1000f) else 0f
            TelemetryEngine.reportHttpStats(url, bytes.size.toLong(), speedKb, duration)

            val readLen = Math.min(bytes.size, length)
            System.arraycopy(bytes, 0, buffer, 0, readLen)
            return@withContext readLen
        }
    }

    override suspend fun close() {
        // No persistent connection bounds
    }

    fun getContentLength(): Long {
        return size
    }
}
