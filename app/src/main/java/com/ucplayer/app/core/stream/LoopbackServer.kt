package com.ucplayer.app.core.stream

import android.net.Uri
import kotlinx.coroutines.*
import java.io.OutputStream
import java.net.ServerSocket
import java.net.Socket
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoopbackServer @Inject constructor(
    private val sessionManager: SessionManager
) {
    private var serverSocket: ServerSocket? = null
    private var isRunning = false
    private val serverScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var activePort: Int = 0

    fun start(): Int {
        if (isRunning) return activePort
        isRunning = true

        // Passing 0 tells the OS to assign any free random port dynamically
        val socket = ServerSocket(0)
        serverSocket = socket
        activePort = socket.localPort

        serverScope.launch {
            try {
                while (isRunning) {
                    val client = socket.accept()
                    launch { handleClient(client) }
                }
            } catch (e: Exception) {
                // ignore shutdown socket errors
            }
        }
        return activePort
    }

    fun stop() {
        isRunning = false
        try {
            serverSocket?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        serverScope.cancel()
    }

    fun getPort(): Int = activePort

    private suspend fun handleClient(client: Socket) = withContext(Dispatchers.IO) {
        com.ucplayer.app.core.stream.PlaybackTracker.log("HTTP GET Received")
        android.util.Log.e("LOOPBACK", "handleClient() ENTERED")
        try {
            val input = client.getInputStream()
            val output = client.getOutputStream()

            val reader = input.bufferedReader()
            val requestLine = reader.readLine() ?: return@withContext
            val parts = requestLine.split(" ")
            if (parts.size < 2 || parts[0] != "GET") {
                sendBadRequest(output)
                return@withContext
            }

            var rangeHeader: String? = null
            var line: String? = reader.readLine()
            while (line != null && line.isNotEmpty()) {
                if (line.startsWith("Range:", ignoreCase = true)) {
                    rangeHeader = line.substring(6).trim()
                }
                line = reader.readLine()
            }

            // Path format: /stream/{sessionId}
            val uri = Uri.parse(parts[1])
            val pathSegments = uri.pathSegments
            if (pathSegments.isEmpty() || pathSegments[0] != "stream") {
                sendBadRequest(output)
                return@withContext
            }

            val sessionId = pathSegments.getOrNull(1)
            if (sessionId == null) {
                sendBadRequest(output)
                return@withContext
            }
            val session = sessionManager.getSession(sessionId)
            android.util.Log.e("LOOPBACK", "SessionId = $sessionId")
            android.util.Log.e("LOOPBACK", "Session exists = ${session != null}")
            if (session == null) {
                sendNotFound(output)
                return@withContext
            }

            val provider = session.provider

            // Prepare and open stream provider if needed
            try {
                android.util.Log.e("LOOPBACK", "Calling provider.prepare()")
                provider.prepare()
                android.util.Log.e("LOOPBACK", "provider.prepare() returned")
                val fileIndex = uri.getQueryParameter("file")?.toIntOrNull() ?: -1
                provider.selectFile(fileIndex)
                provider.open()
            } catch (e: Exception) {
                e.printStackTrace()
                sendInternalServerError(output)
                return@withContext
            }

            val metadata = provider.metadata
            val totalSize = metadata?.contentLength ?: 0L
            val mimeType = metadata?.mimeType ?: "video/mp4"
            var startRange: Long = 0
            var endRange: Long = totalSize - 1

            if (rangeHeader != null && rangeHeader.startsWith("bytes=")) {
                val rangeParts = rangeHeader.substring(6).split("-")
                startRange = rangeParts[0].toLongOrNull() ?: 0L
                if (rangeParts.size > 1 && rangeParts[1].isNotEmpty()) {
                    endRange = rangeParts[1].toLongOrNull() ?: (totalSize - 1)
                }
            }

            if (startRange >= totalSize) {
                sendRangeNotSatisfiable(output, totalSize)
                return@withContext
            }
            if (endRange >= totalSize) {
                endRange = totalSize - 1
            }

            val contentLength = endRange - startRange + 1

            val responseHeaders = "HTTP/1.1 206 Partial Content\r\n" +
                    "Content-Type: $mimeType\r\n" +
                    "Accept-Ranges: bytes\r\n" +
                    "Content-Range: bytes $startRange-$endRange/$totalSize\r\n" +
                    "Content-Length: $contentLength\r\n" +
                    "Connection: close\r\n\r\n"

            output.write(responseHeaders.toByteArray())
            output.flush()

            // Stream chunks using the generic output stream pipe
            provider.read(startRange, output, contentLength)

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                client.close()
            } catch (e: Exception) {
                // ignore
            }
        }
    }

    private fun sendBadRequest(output: OutputStream) {
        val headers = "HTTP/1.1 400 Bad Request\r\n" +
                "Content-Length: 0\r\n" +
                "Connection: close\r\n\r\n"
        output.write(headers.toByteArray())
        output.flush()
    }

    private fun sendNotFound(output: OutputStream) {
        val headers = "HTTP/1.1 404 Not Found\r\n" +
                "Content-Length: 0\r\n" +
                "Connection: close\r\n\r\n"
        output.write(headers.toByteArray())
        output.flush()
    }

    private fun sendInternalServerError(output: OutputStream) {
        val headers = "HTTP/1.1 500 Internal Server Error\r\n" +
                "Content-Length: 0\r\n" +
                "Connection: close\r\n\r\n"
        output.write(headers.toByteArray())
        output.flush()
    }

    private fun sendRangeNotSatisfiable(output: OutputStream, fileSize: Long) {
        val headers = "HTTP/1.1 416 Range Not Satisfiable\r\n" +
                "Content-Range: bytes */$fileSize\r\n" +
                "Content-Length: 0\r\n" +
                "Connection: close\r\n\r\n"
        output.write(headers.toByteArray())
        output.flush()
    }
}
