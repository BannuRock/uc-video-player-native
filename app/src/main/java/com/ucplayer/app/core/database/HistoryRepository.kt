package com.ucplayer.app.core.database

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryRepository @Inject constructor(
    private val historyDao: HistoryDao
) {
    val allHistory: Flow<List<HistoryEntry>> = historyDao.getAllHistory()

    suspend fun getEntry(pageUrl: String): HistoryEntry? {
        return historyDao.getEntry(pageUrl)
    }

    suspend fun addOrUpdateHistory(
        pageUrl: String,
        title: String,
        poster: String?,
        website: String,
        playPosition: Long,
        duration: Long
    ) {
        val entry = HistoryEntry(
            pageUrl = pageUrl,
            title = title,
            poster = poster,
            website = website,
            timestamp = System.currentTimeMillis(),
            playPosition = playPosition,
            duration = duration
        )
        historyDao.insert(entry)
    }

    suspend fun deleteHistory(entry: HistoryEntry) {
        historyDao.delete(entry)
    }

    suspend fun clearHistory() {
        historyDao.clearAll()
    }
}
