package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.ScoutEventResponse
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.local.PlayerEntity
import com.scoutapp.data.mock.MockData
import com.scoutapp.data.model.TransfermarktSearchResult
import com.scoutapp.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoutingViewModel @Inject constructor(
    private val apiService: ScoutApiService,
    private val tmApiService: TransfermarktApiService,
    private val playerDao: PlayerDao,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _recommended = MutableStateFlow<List<PlayerResponse>>(emptyList())
    val recommended: StateFlow<List<PlayerResponse>> = _recommended

    private val _hiddenGems = MutableStateFlow<List<PlayerResponse>>(emptyList())
    val hiddenGems: StateFlow<List<PlayerResponse>> = _hiddenGems

    private val _searchResults = MutableStateFlow<List<TransfermarktSearchResult>>(emptyList())
    val searchResults: StateFlow<List<TransfermarktSearchResult>> = _searchResults

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    val watchlist: StateFlow<List<PlayerResponse>> = playerDao.getWatchlist()
        .map { entities ->
            entities.map { entity ->
                PlayerResponse(
                    id = entity.id,
                    tmId = entity.tmId,
                    name = entity.name,
                    club = entity.club,
                    age = entity.age,
                    marketValue = entity.marketValue,
                    talentScore = entity.talentScore,
                    hiddenGemScore = entity.hiddenGemScore,
                    position = entity.position,
                    photoUrl = null,
                    statistics = null
                )
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isOffline = MutableStateFlow(false)
    val isOffline: StateFlow<Boolean> = _isOffline

    private val _isBackendConnected = MutableStateFlow(false)
    val isBackendConnected: StateFlow<Boolean> = _isBackendConnected

    private val _backendStatusInfo = MutableStateFlow<Map<String, Any>?>(null)
    val backendStatusInfo: StateFlow<Map<String, Any>?> = _backendStatusInfo

    private val _scoutFeed = MutableStateFlow<List<ScoutEventResponse>>(emptyList())
    val scoutFeed: StateFlow<List<ScoutEventResponse>> = _scoutFeed

    fun loadAllData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            if (!networkHelper.isNetworkConnected()) {
                _isOffline.value = true
                loadMockData()
                _isLoading.value = false
                return@launch
            }
            
            _isOffline.value = false
            
            try {
                // We always want to fill Recommended and Hidden Gems from Transfermarkt
                // as requested by the user, while still checking backend status.
                
                val statusResponse = runCatching { apiService.getBackendStatus() }
                val response = statusResponse.getOrNull()
                
                if (statusResponse.isSuccess && response != null && response.isSuccessful) {
                    _isBackendConnected.value = true
                    _backendStatusInfo.value = response.body()
                    
                    // Try to load feed from backend
                    val feedResult = runCatching { apiService.getScoutFeed() }
                    if (feedResult.isSuccess) {
                        _scoutFeed.value = feedResult.getOrThrow()
                    }
                } else {
                    _isBackendConnected.value = false
                }

                // Load Recommended and Hidden Gems from TM
                loadDataFromTransfermarkt()
                
            } catch (e: Exception) {
                _error.value = "Unexpected Error: ${e.message}"
                loadDataFromTransfermarkt()
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun loadDataFromTransfermarkt() {
        try {
            val searchResult = runCatching { tmApiService.searchAll("prospect") }
            val searchResponse = searchResult.getOrNull()
            
            if (searchResponse != null) {
                val filteredPlayers = (searchResponse.players?.results ?: emptyList())
                    .filter { (it.age ?: 30) <= 24 }
                    .map { tmPlayer ->
                        PlayerResponse(
                            id = 0L,
                            tmId = tmPlayer.id,
                            name = tmPlayer.name,
                            club = tmPlayer.clubName,
                            age = tmPlayer.age,
                            marketValue = parseMarketValueToDouble(tmPlayer.marketValue),
                            talentScore = 85.0,
                            hiddenGemScore = 0.0,
                            position = tmPlayer.position,
                            photoUrl = tmPlayer.imageUrl,
                            statistics = null
                        )
                    }
                _recommended.value = filteredPlayers
            }

            val gemsResult = runCatching { tmApiService.searchAll("wonderkid") }
            val gemsResponse = gemsResult.getOrNull()
            
            if (gemsResponse != null) {
                val filteredGems = (gemsResponse.players?.results ?: emptyList())
                    .filter { (it.age ?: 30) <= 22 }
                    .map { tmPlayer ->
                        PlayerResponse(
                            id = 0L,
                            tmId = tmPlayer.id,
                            name = tmPlayer.name,
                            club = tmPlayer.clubName,
                            age = tmPlayer.age,
                            marketValue = parseMarketValueToDouble(tmPlayer.marketValue),
                            talentScore = 0.0,
                            hiddenGemScore = 92.0,
                            position = tmPlayer.position,
                            photoUrl = tmPlayer.imageUrl,
                            statistics = null
                        )
                    }
                _hiddenGems.value = filteredGems
            }
            
            if (searchResult.isFailure && gemsResult.isFailure) {
                _error.value = "TM API Unavailable"
            }
        } catch (e: Exception) {
            // Silently handle outer exception to prevent crash
            println("loadDataFromTransfermarkt error: ${e.message}")
        }
    }

    fun searchPlayers(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = runCatching { tmApiService.searchAll(query) }
            result.onSuccess { response ->
                _searchResults.value = response.players?.results ?: emptyList()
            }.onFailure { e ->
                _error.value = "Search error: ${e.message}"
            }
            _isLoading.value = false
        }
    }

    private fun parseMarketValueToDouble(valueStr: String?): Double {
        if (valueStr == null || valueStr.isEmpty() || valueStr == "N/A") return 0.0
        val cleanStr = valueStr.replace("€", "").trim().lowercase()
        return try {
            val multiplier = when {
                cleanStr.contains("m") -> 1_000_000.0
                cleanStr.contains("k") -> 1_000.0
                else -> 1.0
            }
            val numericPart = cleanStr.replace(Regex("[^0-9.]"), "")
            if (numericPart.isEmpty()) 0.0 else numericPart.toDouble() * multiplier
        } catch (e: Exception) {
            0.0
        }
    }

    private fun loadMockData() {
        _recommended.value = MockData.players.take(5)
        _hiddenGems.value = MockData.players.drop(5).take(5)
        _scoutFeed.value = MockData.events
    }

    fun triggerSync() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                apiService.syncLeague("PL")
                loadAllData()
            } catch (e: Exception) {
                _error.value = "Sync error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun startupBackend() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                apiService.startupBackend()
                loadAllData()
            } catch (e: Exception) {
                _error.value = "Startup error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetBackendData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                apiService.resetBackendData()
                loadAllData()
            } catch (e: Exception) {
                _error.value = "Reset error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
