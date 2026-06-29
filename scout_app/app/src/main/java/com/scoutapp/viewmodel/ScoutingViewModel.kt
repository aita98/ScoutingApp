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
import com.scoutapp.data.repository.EnrichmentRepository
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
    private val enrichmentRepository: EnrichmentRepository,
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

    private var previousOtwIds = setOf<String>()
    private var previousGemIds = setOf<String>()

    init {
        monitorBackendSync()
        observeDatabasePlayers()
        enrichPlayersMissingData()
    }

    private fun enrichPlayersMissingData() {
        viewModelScope.launch {
            // Wait a bit after startup
            delay(5000)
            
            playerDao.getAllPlayers().firstOrNull()?.let { allPlayers ->
                // Sort to prioritize Gems and Talents first, then most recently updated
                val missingDataPlayers = allPlayers.filter { it.age == null || it.photoUrl == null }
                    .sortedWith(compareByDescending<com.scoutapp.data.local.PlayerEntity> { it.talentScore > 0 || it.hiddenGemScore > 0 }
                        .thenByDescending { it.lastUpdated })
                
                if (missingDataPlayers.isNotEmpty()) {
                    android.util.Log.d("SCOUT_VM", "Found ${missingDataPlayers.size} players missing age/photo. Starting priority enrichment...")
                    
                    // Limit to a reasonable number to avoid hitting API rate limits too hard
                    missingDataPlayers.take(20).forEach { player ->
                        val tmId = player.tmId
                        if (tmId != null) {
                            try {
                                android.util.Log.d("SCOUT_VM", "Auto-enriching ${player.name} ($tmId)")
                                enrichmentRepository.getFullPlayerData(player.id, tmId)
                                delay(2000) // Slightly longer delay between requests to be safe
                            } catch (e: Exception) {
                                android.util.Log.e("SCOUT_VM", "Failed to enrich ${player.name}: ${e.message}")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun observeDatabasePlayers() {
        playerDao.getAllPlayers()
            .onEach { entities ->
                val allPlayers = entities.map { entity ->
                    PlayerResponse(
                        id = entity.id,
                        tmId = entity.tmId,
                        transfermarktId = entity.tmId,
                        name = entity.name,
                        club = entity.club,
                        age = entity.age,
                        marketValue = entity.marketValue,
                        talentScore = entity.talentScore,
                        hiddenGemScore = entity.hiddenGemScore,
                        position = entity.position,
                        photoUrl = entity.photoUrl,
                        isRetired = entity.isRetired,
                        minutes = entity.minutes,
                        matchesPlayed = entity.matchesPlayed,
                        appearances = entity.appearances,
                        statistics = if (!entity.seasonalStats.isNullOrEmpty()) {
                            try {
                                com.google.gson.Gson().fromJson<List<com.scoutapp.data.api.SeasonStats>>(
                                    entity.seasonalStats,
                                    object : com.google.gson.reflect.TypeToken<List<com.scoutapp.data.api.SeasonStats>>() {}.type
                                )
                            } catch (e: Exception) { null }
                        } else null
                    )
                }

                // Filtering Logic
                // 1) LISTA “CONSIGLIATI” (One To Watch): 22 < Age <= 25, Titolarità >= 70%
                // 2) LISTA “HIDDEN GEMS”: Age <= 22, 25% <= Titolarità <= 70%
                
                val currentOtw = allPlayers.filter { p ->
                    val age = p.age ?: 100
                    val ownership = calculateOwnership(p)
                    val rawMv = p.marketValue ?: 0.0
                    val normalizedMv = if (rawMv > 0 && rawMv < 1000) rawMv * 1_000_000.0 else rawMv
                    
                    val match = age > 22 && age <= 25 && ownership >= 70.0 && normalizedMv <= 15_000_000.0
                    if (match) {
                        android.util.Log.d("FILTER_DEBUG", "CONS: ${p.name} Age=$age Own=${String.format("%.1f", ownership)}% VDM=${String.format("%.0f", normalizedMv)}")
                    } else if (age in 23..25) {
                        android.util.Log.d("FILTER_DEBUG", "CONS_FAIL: ${p.name} Age=$age Own=${String.format("%.1f", ownership)}% VDM=${String.format("%.0f", normalizedMv)}")
                    }
                    match
                }.sortedByDescending { it.talentScore }

                val currentGems = allPlayers.filter { p ->
                    val age = p.age ?: 100
                    val ownership = calculateOwnership(p)
                    val rawMv = p.marketValue ?: 0.0
                    val normalizedMv = if (rawMv > 0 && rawMv < 1000) rawMv * 1_000_000.0 else rawMv
                    
                    val match = age <= 22 && ownership >= 25.0 && ownership <= 70.0 && normalizedMv <= 5_000_000.0
                    if (match) {
                        android.util.Log.d("FILTER_DEBUG", "GEM: ${p.name} Age=$age Own=${String.format("%.1f", ownership)}% VDM=${String.format("%.0f", normalizedMv)}")
                    } else if (age <= 22) {
                        android.util.Log.d("FILTER_DEBUG", "GEM_FAIL: ${p.name} Age=$age Own=${String.format("%.1f", ownership)}% VDM=${String.format("%.0f", normalizedMv)}")
                    }
                    match
                }.sortedByDescending { it.hiddenGemScore }

                // Detect new additions for Scout Feed
                if (previousOtwIds.isNotEmpty()) {
                    val newOtw = currentOtw.filter { !previousOtwIds.contains(it.tmId ?: it.id.toString()) }
                    newOtw.forEach { p ->
                        generateLocalFeedEvent(p, "NEW_CONS_PLAYER", "Nuovo 'Consigliato' scoperto")
                    }
                }
                
                if (previousGemIds.isNotEmpty()) {
                    val newGems = currentGems.filter { !previousGemIds.contains(it.tmId ?: it.id.toString()) }
                    newGems.forEach { p ->
                        generateLocalFeedEvent(p, "NEW_GEM_PLAYER", "Nuova 'Hidden Gem' scoperta")
                    }
                }

                // Update previous state for next detection
                previousOtwIds = currentOtw.map { it.tmId ?: it.id.toString() }.toSet()
                previousGemIds = currentGems.map { it.tmId ?: it.id.toString() }.toSet()

                _otw.value = currentOtw
                _hiddenGems.value = currentGems
            }
            .launchIn(viewModelScope)
    }

    private fun generateLocalFeedEvent(player: PlayerResponse, type: String, description: String) {
        val event = ScoutEventResponse(
            id = System.currentTimeMillis(),
            eventType = type,
            description = "$description: ${player.name} (${player.club ?: "Svincolato"})",
            createdAt = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault()).format(java.util.Date()),
            player = player
        )
        _scoutFeed.value = (listOf(event) + _scoutFeed.value).distinctBy { it.player?.tmId ?: it.id.toString() }.take(50)
    }

    private fun calculateOwnership(player: PlayerResponse): Double {
        // Find the main league entry in the stats list (the one with the most minutes)
        val statsList = player.statistics
        val mainSeasonEntry = statsList?.maxByOrNull { it.minutesPlayed ?: 0 }
        
        val minutes = mainSeasonEntry?.minutesPlayed ?: player.minutes ?: 0
        
        // If we have direct appearances/matchesPlayed from player object, prefer that as fallback
        var totalMatches = mainSeasonEntry?.appearances 
            ?: (if (!statsList.isNullOrEmpty()) 0 else (player.matchesPlayed ?: player.appearances ?: 0))

        // If still 0, try to aggregate from all statistics entries
        if (totalMatches <= 0 && !statsList.isNullOrEmpty()) {
            totalMatches = statsList.sumOf { it.appearances ?: 0 }
        }
        
        if (totalMatches <= 0) {
            // If we have minutes but no appearances info, we can't reliably calculate %.
            // However, to avoid losing players, if they have > 450 mins (5 full games) 
            // but no match count, assume they are at least somewhat regular.
            return if (minutes > 450) 60.0 else if (minutes > 0) 30.0 else 0.0
        }
        
        // titolarità = (minuti giocati / (partite totali * 90)) * 100
        val ownership = (minutes.toDouble() / (totalMatches * 90.0)) * 100.0
        
        // Cap at 100%
        return ownership.coerceAtMost(100.0)
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
            
            // connectivity check only
            val isConnected = networkHelper.isNetworkConnected()
            _isOffline.value = !isConnected
            
            if (isConnected) {
                try {
                    val statusResponse = runCatching { apiService.getBackendStatus() }
                    val response = statusResponse.getOrNull()
                    
                    if (statusResponse.isSuccess && response != null && response.isSuccessful) {
                        _isBackendConnected.value = true
                        _backendStatusInfo.value = response.body()
                        
                        // Periodic Feed update from backend
                        val feedResult = runCatching { apiService.getScoutFeed() }
                        if (feedResult.isSuccess) {
                            _scoutFeed.value = (feedResult.getOrThrow() + _scoutFeed.value)
                                .distinctBy { it.id.toString() + (it.player?.tmId ?: "") }
                                .take(100)
                        }

                        // Sync OTW and Gems to local DB to ensure lists are populated
                        viewModelScope.launch {
                            val otwResponse = runCatching { apiService.getOneToWatch() }.getOrNull()
                            if (otwResponse != null) {
                                savePlayersToDb(otwResponse)
                                android.util.Log.d("SCOUT_VM", "Synced ${otwResponse.size} OTW players from backend")
                            }
                            
                            val gemsResponse = runCatching { apiService.getHiddenGems() }.getOrNull()
                            if (gemsResponse != null) {
                                savePlayersToDb(gemsResponse)
                                android.util.Log.d("SCOUT_VM", "Synced ${gemsResponse.size} Hidden Gems from backend")
                            }
                        }
                    } else {
                        _isBackendConnected.value = false
                    }
                } catch (e: Exception) {
                    android.util.Log.e("SCOUT_VM", "Sync error: ${e.message}")
                }
            }
            _isLoading.value = false
        }
    }

    private suspend fun savePlayersToDb(players: List<PlayerResponse>) {
        val entities = players.map { p ->
            val tmId = p.tmId ?: p.transfermarktId ?: ""
            val dbId = if (p.id == 0L) {
                tmId.toLongOrNull() ?: (tmId.hashCode().toLong() and 0x7FFFFFFFFFFFFFFFL)
            } else p.id

            com.scoutapp.data.local.PlayerEntity(
                id = dbId,
                tmId = tmId,
                name = p.name ?: "Unknown",
                club = p.club,
                league = p.league,
                age = p.age,
                marketValue = p.marketValue,
                talentScore = p.talentScore ?: 0.0,
                hiddenGemScore = p.hiddenGemScore ?: 0.0,
                position = p.position,
                photoUrl = p.photoUrl,
                isRetired = p.isRetired ?: false,
                minutes = p.minutes,
                matchesPlayed = p.matchesPlayed,
                appearances = p.appearances,
                seasonalStats = com.google.gson.Gson().toJson(p.statistics),
                lastUpdated = System.currentTimeMillis()
            )
        }
        playerDao.upsertPlayersPreservingLocalFields(entities)
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
