package com.ucplayer.app.core.parser

import com.ucplayer.app.models.VideoInfo

interface ParserPlugin {
    fun canHandle(url: String): Boolean
    suspend fun extract(url: String): VideoInfo
}
