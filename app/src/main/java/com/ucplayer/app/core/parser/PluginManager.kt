package com.ucplayer.app.core.parser

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PluginManager @Inject constructor(
    private val plugins: Set<@JvmSuppressWildcards ParserPlugin>
) {
    fun getParserFor(url: String): ParserPlugin? {
        return plugins.firstOrNull { it.canHandle(url) }
    }
}
