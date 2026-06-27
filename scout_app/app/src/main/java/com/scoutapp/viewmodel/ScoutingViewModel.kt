package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.ScoutEventResponse
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.mock.MockData
import com.scoutapp.data.model.SyncStatus
import com.scoutapp.data.model.TransfermarktSearchResult
import com.scoutapp.domain.repository.PlayerRepository
import com.scoutapp.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoutingViewModel @Inject constructor(
    private val apiService: ScoutApiService,
    private val tmApiService: TransfermarktApiService,
    private val playerRepository: PlayerRepository,
    private val playerDao: PlayerDao,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _otw = MutableStateFlow<List<PlayerResponse>>(emptyList())
    val otw: StateFlow<List<PlayerResponse>> = _otw

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
                    fbrefSlug = entity.fbrefSlug,
                    name = entity.name,
                    club = entity.club,
                    age = entity.age,
                    marketValue = entity.marketValue,
                    talentScore = entity.talentScore,
                    hiddenGemScore = entity.hiddenGemScore,
                    position = entity.position,
                    photoUrl = entity.photoUrl,
                    isRetired = entity.isRetired
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

    private val _syncStatus = MutableStateFlow<SyncStatus?>(null)
    val syncStatus: StateFlow<SyncStatus?> = _syncStatus

    init {
        monitorBackendSync()
    }

    private fun monitorBackendSync() {
        viewModelScope.launch {
            while (true) {
                try {
                    if (networkHelper.isNetworkConnected()) {
                        val response = apiService.getSyncStatus()
                        if (response.isSuccessful) {
                            _syncStatus.value = response.body()
                        }
                    }
                } catch (e: Exception) {
                    // Ignore background sync check errors
                }
                delay(3000)
            }
        }
    }

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
                val statusResponse = runCatching { apiService.getBackendStatus() }
                val response = statusResponse.getOrNull()
                
                if (statusResponse.isSuccess && response != null && response.isSuccessful) {
                    _isBackendConnected.value = true
                    _backendStatusInfo.value = response.body()
                    
                    val otwResult = runCatching { apiService.getOneToWatch() }
                    if (otwResult.isSuccess) {
                        _otw.value = otwResult.getOrThrow()
                    }

                    val gemsResult = runCatching { apiService.getHiddenGems() }
                    if (gemsResult.isSuccess) {
                        _hiddenGems.value = gemsResult.getOrThrow()
                    }

                    val feedResult = runCatching { apiService.getScoutFeed() }
                    if (feedResult.isSuccess) {
                        _scoutFeed.value = feedResult.getOrThrow()
                    }
                } else {
                    _isBackendConnected.value = false
                }

                // loadDataFromTransfermarkt() // REMOVED: Now backend-driven
                
            } catch (e: Exception) {
                _error.value = "Unexpected Error: ${e.message}"
                // loadDataFromTransfermarkt() // REMOVED: Now backend-driven
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
                            photoUrl = tmPlayer.imageUrl
                        )
                    }
                _otw.value = filteredPlayers
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
                            photoUrl = tmPlayer.imageUrl
                        )
                    }
                _hiddenGems.value = filteredGems
            }
        } catch (e: Exception) {
            println("loadDataFromTransfermarkt error: ${e.message}")
        }
    }

    fun searchPlayers(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = runCatching { tmApiService.searchAll(query) }
            result.onSuccess { response ->
                val players = response.results ?: response.players?.results ?: emptyList()
                _searchResults.value = players
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
        _otw.value = MockData.players.take(5)
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
