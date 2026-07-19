package com.ucplayer.app.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryEntry(
    @PrimaryKey val pageUrl: String,
    val title: String,
    val poster: String?,
    val website: String,
    val timestamp: Long,
    val playPosition: Long = 0L,
    val duration: Long = 0L
)
