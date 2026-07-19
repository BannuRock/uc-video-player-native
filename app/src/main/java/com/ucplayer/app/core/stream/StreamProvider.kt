package com.ucplayer.app.core.stream

import com.ucplayer.app.core.stream.models.MediaMetadata
import com.ucplayer.app.core.stream.models.PieceState
import com.ucplayer.app.core.stream.models.StreamStatistics
import java.io.OutputStream

interface StreamProvider {
    val sessionId: String
    val metadata: MediaMetadata?

    suspend fun prepare()
    suspend fun open()
    suspend fun read(offset: Long, output: OutputStream, length: Long): Long
    suspend fun stop()
    suspend fun close()
    fun getPieceStates(): List<PieceState>
    fun getStatistics(): StreamStatistics

    suspend fun selectFile(fileIndex: Int) {}
    fun getTorrentFiles(): List<String> = emptyList()
    fun setSchedulerMode(mode: com.ucplayer.app.core.stream.models.SchedulerMode) {}
}
