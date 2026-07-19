package com.ucplayer.app.core.stream

import com.ucplayer.app.core.stream.models.SchedulerMode
import com.ucplayer.app.core.stream.models.StreamState
import com.ucplayer.app.core.stream.models.StreamStatistics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GenericStreamSession(
    override val provider: StreamProvider,
    sessionId: String
) : StreamSession(sessionId) {

    private val _state = MutableStateFlow(StreamState.CREATED)
    override val state: StateFlow<StreamState> = _state.asStateFlow()

    private val _statistics = MutableStateFlow(provider.getStatistics())
    override val statistics: StateFlow<StreamStatistics> = _statistics.asStateFlow()

    private val sessionScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    init {
        sessionScope.launch {
            try {
                while (true) {
                    val stats = provider.getStatistics()
                    _state.value = stats.streamState
                    _statistics.value = stats
                    delay(500)
                }
            } catch (e: Exception) {
                // handle shutdown
            }
        }
    }

    override fun setSchedulerMode(mode: SchedulerMode) {
        provider.setSchedulerMode(mode)
    }
}
