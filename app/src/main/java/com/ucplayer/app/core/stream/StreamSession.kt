package com.ucplayer.app.core.stream

import com.ucplayer.app.core.stream.models.SchedulerMode
import com.ucplayer.app.core.stream.models.StreamState
import com.ucplayer.app.core.stream.models.StreamStatistics
import kotlinx.coroutines.flow.StateFlow

abstract class StreamSession(val sessionId: String) {
    abstract val provider: StreamProvider
    abstract val state: StateFlow<StreamState>
    abstract val statistics: StateFlow<StreamStatistics>
    
    abstract fun setSchedulerMode(mode: SchedulerMode)
}
