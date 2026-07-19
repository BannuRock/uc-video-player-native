package com.ucplayer.app.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucplayer.app.core.database.HistoryEntry
import com.ucplayer.app.core.database.HistoryRepository
import com.ucplayer.app.core.parser.PluginManager
import com.ucplayer.app.models.VideoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeUiState {
    object Idle : HomeUiState
    object Loading : HomeUiState
    data class Success(val info: VideoInfo) : HomeUiState
    data class Error(val message: String) : HomeUiState
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pluginManager: PluginManager,
    private val historyRepository: HistoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
    val uiState: StateFlow<HomeUiState> = _uiState

    val historyList: StateFlow<List<HistoryEntry>> = historyRepository.allHistory
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun scrapeUrl(url: String) {
        if (url.trim().isEmpty()) {
            _uiState.value = HomeUiState.Error("Please enter a valid URL")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = HomeUiState.Loading
            try {
                val parser = pluginManager.getParserFor(url)
                if (parser == null) {
                    _uiState.value = HomeUiState.Error("No scraper plugin registered for this URL")
                    return@launch
                }
                
                val videoInfo = parser.extract(url)
                _uiState.value = HomeUiState.Success(videoInfo)

                // Add to Room history
                historyRepository.addOrUpdateHistory(
                    pageUrl = videoInfo.pageUrl,
                    title = videoInfo.title,
                    poster = videoInfo.poster,
                    website = videoInfo.website,
                    playPosition = 0L,
                    duration = 0L
                )
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = HomeUiState.Error(e.message ?: "An unexpected error occurred during scraping")
            }
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            historyRepository.clearHistory()
        }
    }

    fun deleteHistoryEntry(entry: HistoryEntry) {
        viewModelScope.launch {
            historyRepository.deleteHistory(entry)
        }
    }

    fun resetState() {
        _uiState.value = HomeUiState.Idle
    }
}
