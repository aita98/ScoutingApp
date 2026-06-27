package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.*
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.local.PlayerEntity
import com.scoutapp.data.model.*
import com.scoutapp.data.repository.EnrichmentRepository
import com.scoutapp.domain.model.PlayerStats
import com.scoutapp.domain.repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.async
import javax.inject.Inject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Deferred

sealed class PlayerDetailState {
    object Loading : PlayerDetailState()
    data class Success(
        val player: com.scoutapp.data.api.PlayerResponse, 
        val radar: RadarResponse? = null,
        val isWatchlisted: Boolean = false,
        val tmTransfers: List<TransfermarktTransfer> = emptyList(),
        val tmInjuries: List<TransfermarktInjury> = emptyList(),
        val tmAchievements: List<TransfermarktAchievement> = emptyList(),
        val tmMarketValueHistory: List<TransfermarktMarketValuePoint> = emptyList(),
        val tmDetailedStats: List<TransfermarktDetailedStat> = emptyList(),
        val fbrefStats: PlayerStats? = null,
        val foot: String? = null,
        val shirtNumber: String? = null,
        val citizenship: List<String> = emptyList(),
        val contractExpires: String? = null,
        val birthDate: String? = null,
        val availableSeasons: List<String> = emptyList(),
        val selectedSeason: String? = null,
        val recentMatches: List<RecentMatch> = emptyList(),
        val enrichedData: PlayerFullData? = null,
        val isStatsLoading: Boolean = false
    ) : PlayerDetailState()
    data class Error(val message: String) : PlayerDetailState()
}

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val apiService: ScoutApiService,
    private val tmApiService: TransfermarktApiService,
    private val playerRepository: PlayerRepository,
    private val playerDao: PlayerDao,
    private val enrichmentRepository: EnrichmentRepository,
    private val gson: Gson
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlayerDetailState>(PlayerDetailState.Loading)
    val uiState: StateFlow<PlayerDetailState> = _uiState

    fun loadPlayer(idString: String, forceRefresh: Boolean = false) {
        viewModelScope.launch {
            try {
                _uiState.value = PlayerDetailState.Loading
                android.util.Log.d("API_DEBUG", "[START] Loading player: $idString (forceRefresh=$forceRefresh)")

                // 1. Initial season calculation
                val now = java.util.Calendar.getInstance()
                val currentYear = now.get(java.util.Calendar.YEAR)
                val currentMonth = now.get(java.util.Calendar.MONTH) + 1
                val targetSeasonYear = if (currentMonth >= 7) currentYear else currentYear - 1
                val displaySeason = "${targetSeasonYear.toString().takeLast(2)}/${(targetSeasonYear + 1).toString().takeLast(2)}"

                // 2. Parallel initialization of core components
                val enrichmentDef = async { enrichmentRepository.getFullPlayerData(0L, idString) }
                
                // 3. Cache Check
                if (!forceRefresh) {
                    val cached = playerDao.getPlayerByTmId(idString) 
                        ?: (if (idString.toLongOrNull() != null) playerDao.getPlayerById(idString.toLong()) else null)
                        ?: playerDao.getPlayerByName("%$idString%")

                    if (cached != null && System.currentTimeMillis() - cached.lastUpdated < 43200000) {
                        try {
                            android.util.Log.d("CACHE", "[HIT] Restoring from local DB for $idString")
                            val playerResponse = com.scoutapp.data.api.PlayerResponse(
                                id = cached.id,
                                transfermarktId = cached.tmId,
                                tmId = cached.tmId,
                                fbrefSlug = cached.fbrefSlug,
                                name = cached.name,
                                club = cached.club,
                                age = cached.age,
                                marketValue = cached.marketValue,
                                talentScore = cached.talentScore,
                                hiddenGemScore = cached.hiddenGemScore,
                                position = cached.position,
                                photoUrl = cached.photoUrl,
                                isRetired = cached.isRetired,
                                statistics = if (cached.seasonalStats != null && cached.seasonalStats != "null") runCatching { gson.fromJson<List<SeasonStats>>(cached.seasonalStats, object : TypeToken<List<SeasonStats>>() {}.type) }.getOrNull() else null,
                                radar = if (cached.radarData != null && cached.radarData != "null") runCatching { gson.fromJson(cached.radarData, RadarResponse::class.java) }.getOrNull() else null
                            )

                            _uiState.value = PlayerDetailState.Success(
                                player = playerResponse,
                                isWatchlisted = cached.isWatchlisted,
                                tmTransfers = if (!cached.transfers.isNullOrEmpty() && cached.transfers != "null") runCatching { gson.fromJson<List<TransfermarktTransfer>>(cached.transfers, object : TypeToken<List<TransfermarktTransfer>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                tmInjuries = if (!cached.injuries.isNullOrEmpty() && cached.injuries != "null") runCatching { gson.fromJson<List<TransfermarktInjury>>(cached.injuries, object : TypeToken<List<TransfermarktInjury>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                tmAchievements = if (!cached.achievements.isNullOrEmpty() && cached.achievements != "null") runCatching { gson.fromJson<List<TransfermarktAchievement>>(cached.achievements, object : TypeToken<List<TransfermarktAchievement>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                tmMarketValueHistory = if (!cached.marketValueHistory.isNullOrEmpty() && cached.marketValueHistory != "null") runCatching { gson.fromJson<List<TransfermarktMarketValuePoint>>(cached.marketValueHistory, object : TypeToken<List<TransfermarktMarketValuePoint>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                tmDetailedStats = if (!cached.detailedStats.isNullOrEmpty() && cached.detailedStats != "null") runCatching { gson.fromJson<List<TransfermarktDetailedStat>>(cached.detailedStats, object : TypeToken<List<TransfermarktDetailedStat>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                foot = cached.foot,
                                shirtNumber = cached.shirtNumber,
                                citizenship = if (!cached.citizenship.isNullOrEmpty() && cached.citizenship != "null") runCatching { gson.fromJson<List<String>>(cached.citizenship, object : TypeToken<List<String>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                contractExpires = cached.contractExpires,
                                birthDate = cached.birthDate,
                                fbrefStats = if (!cached.fbrefStatsJson.isNullOrEmpty() && cached.fbrefStatsJson != "null") runCatching { gson.fromJson(cached.fbrefStatsJson, PlayerStats::class.java) }.getOrNull() else null,
                                radar = playerResponse.radar,
                                recentMatches = if (!cached.recentPerformanceJson.isNullOrEmpty() && cached.recentPerformanceJson != "null") runCatching { gson.fromJson<List<RecentMatch>>(cached.recentPerformanceJson, object : TypeToken<List<RecentMatch>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                                selectedSeason = displaySeason,
                                enrichedData = enrichmentDef.await(),
                                isStatsLoading = false
                            )
                            return@launch
                        } catch (e: Exception) {
                            android.util.Log.e("CACHE", "Error restoring cache: ${e.message}")
                        }
                    }
                }

                // 4. Parallel Data Fetching - DISPATCH ALL AT ONCE
                android.util.Log.d("API_DEBUG", "[DISPATCH] Starting all parallel requests for $idString")
                
                val tmProfileDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting PROFILE: $idString")
                    kotlinx.coroutines.withTimeoutOrNull(8000) {
                        runCatching { tmApiService.getPlayerProfile(idString) }.getOrNull()
                    }
                }
                
                val backendDetailDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting BACKEND DETAIL: $idString")
                    kotlinx.coroutines.withTimeoutOrNull(5000) {
                        runCatching { apiService.getPlayerDetail(idString) }.getOrNull()
                    }
                }

                val transfersDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting TRANSFERS: $idString")
                    runCatching { tmApiService.getPlayerTransfers(idString).transfers }.getOrNull()
                }

                val injuriesDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting INJURIES: $idString")
                    runCatching { tmApiService.getPlayerInjuries(idString).injuries }.getOrNull()
                }

                val achievementsDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting ACHIEVEMENTS: $idString")
                    runCatching { tmApiService.getPlayerAchievements(idString).achievements }.getOrNull()
                }

                val historyDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting MARKET VALUE HISTORY: $idString")
                    runCatching { tmApiService.getPlayerMarketValue(idString).history }.getOrNull()
                }

                val detailedDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting DETAILED STATS: $idString")
                    runCatching { tmApiService.getPlayerDetailedStats(idString).stats }.getOrNull()
                }

                val jerseyDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting JERSEY NUMBERS: $idString")
                    runCatching { tmApiService.getPlayerJerseyNumbers(idString).jerseyNumbers }.getOrNull()
                }

                val radarDef = async {
                    android.util.Log.d("API_DEBUG", "-> Requesting RADAR: $idString")
                    runCatching { apiService.getPlayerRadar(idString) }.getOrNull()
                }

                // 5. WAIT FOR ALL (AWAIT)
                val tmProfile = tmProfileDef.await()
                val playerResponse = backendDetailDef.await()
                val tmTransfers = transfersDef.await() ?: emptyList()
                val tmInjuries = injuriesDef.await() ?: emptyList()
                val tmAchievements = achievementsDef.await() ?: emptyList()
                val tmHistory = historyDef.await() ?: emptyList()
                val tmDetailed = detailedDef.await() ?: emptyList()
                val tmJersey = jerseyDef.await() ?: emptyList()
                val radarResponse = radarDef.await()
                val enrichedData = enrichmentDef.await()

                android.util.Log.d("API_DEBUG", "[RECEIVE] All parallel data received for $idString")

                if (playerResponse == null && tmProfile == null) {
                    _uiState.value = PlayerDetailState.Error("Player data unavailable for: $idString")
                    return@launch
                }

                // 6. Data Mapping
                val tmId = tmProfile?.id ?: playerResponse?.tmId ?: playerResponse?.transfermarktId ?: idString
                
                val basePlayer = playerResponse ?: com.scoutapp.data.api.PlayerResponse(
                    id = 0L,
                    transfermarktId = tmId,
                    tmId = tmId,
                    name = tmProfile?.name ?: "Unknown",
                    club = tmProfile?.club?.name,
                    age = tmProfile?.age ?: calculateAgeFromDescription(tmProfile?.description),
                    marketValue = parseMarketValueFromProfile(tmProfile?._marketValue),
                    marketValueDisplay = tmProfile?.marketValue,
                    position = tmProfile?.position?.main,
                    photoUrl = tmProfile?.imageUrl,
                    isRetired = tmProfile?.isRetired ?: false
                )
                
                val finalPlayer = basePlayer.copy(
                    photoUrl = basePlayer.photoUrl ?: tmProfile?.imageUrl,
                    age = basePlayer.age ?: calculateAgeFromDescription(tmProfile?.description),
                    marketValue = if (basePlayer.marketValue == null || basePlayer.marketValue == 0.0) parseMarketValueFromProfile(tmProfile?._marketValue) else basePlayer.marketValue
                )

                val localPlayer = if (tmId.isNotEmpty()) playerDao.getPlayerByTmId(tmId) else null
                val finalRadar = radarResponse ?: basePlayer.radar ?: RadarResponse(60, 60, 60, 60, 60, 60)
                val resolvedShirtNumber = tmJersey.firstOrNull()?.number ?: tmProfile?.shirtNumber

                _uiState.value = PlayerDetailState.Success(
                    player = finalPlayer,
                    isWatchlisted = localPlayer?.isWatchlisted ?: false,
                    tmTransfers = tmTransfers,
                    tmInjuries = tmInjuries,
                    tmAchievements = tmAchievements,
                    tmMarketValueHistory = tmHistory,
                    tmDetailedStats = tmDetailed,
                    fbrefStats = null,
                    foot = tmProfile?.foot,
                    shirtNumber = resolvedShirtNumber,
                    citizenship = tmProfile?.citizenship ?: emptyList(),
                    contractExpires = tmProfile?.club?.contractExpires,
                    birthDate = extractBirthDate(tmProfile?.description),
                    radar = finalRadar,
                    recentMatches = finalPlayer.recentMatches ?: emptyList(),
                    selectedSeason = displaySeason,
                    enrichedData = enrichedData,
                    isStatsLoading = false
                )

                // 7. Save to Local Cache
                try {
                    val dbId = if (finalPlayer.id == 0L) {
                        tmId.toLongOrNull() ?: (tmId.hashCode().toLong() and 0x7FFFFFFFFFFFFFFFL)
                    } else finalPlayer.id
                    
                    val entity = PlayerEntity(
                        id = dbId,
                        tmId = tmId,
                        name = finalPlayer.name ?: "Unknown",
                        club = finalPlayer.club,
                        age = finalPlayer.age,
                        marketValue = finalPlayer.marketValue,
                        position = finalPlayer.position,
                        photoUrl = finalPlayer.photoUrl,
                        isRetired = finalPlayer.isRetired ?: false,
                        talentScore = finalPlayer.talentScore ?: 0.0,
                        hiddenGemScore = finalPlayer.hiddenGemScore ?: 0.0,
                        isWatchlisted = localPlayer?.isWatchlisted ?: false,
                        foot = tmProfile?.foot,
                        shirtNumber = resolvedShirtNumber,
                        citizenship = gson.toJson(tmProfile?.citizenship),
                        contractExpires = tmProfile?.club?.contractExpires,
                        birthDate = extractBirthDate(tmProfile?.description),
                        detailedStats = gson.toJson(tmDetailed),
                        achievements = gson.toJson(tmAchievements),
                        marketValueHistory = gson.toJson(tmHistory),
                        transfers = gson.toJson(tmTransfers),
                        injuries = gson.toJson(tmInjuries),
                        radarData = gson.toJson(finalRadar),
                        recentPerformanceJson = gson.toJson(finalPlayer.recentMatches),
                        seasonalStats = gson.toJson(finalPlayer.statistics),
                        lastUpdated = System.currentTimeMillis()
                    )
                    playerDao.insertPlayers(listOf(entity))
                } catch (e: Exception) {
                    android.util.Log.e("CACHE", "Error saving to cache: ${e.message}")
                }

            } catch (e: Exception) {
                android.util.Log.e("PLAYER_DETAIL", "Global load error: ${e.message}", e)
                _uiState.value = PlayerDetailState.Error("Detail Error: ${e.message}")
            }
        }
    }

    private fun calculateAgeFromDescription(description: String?): Int? {
        if (description == null) return null
        return try {
            val regex = Regex(", (\\d{1,2}), from")
            val match = regex.find(description)
            match?.groupValues?.get(1)?.toIntOrNull()
        } catch (e: Exception) {
            null
        }
    }

    private fun extractBirthDate(description: String?): String? {
        if (description == null) return null
        return try {
            val regex = Regex("\\* (\\d{2}/\\d{2}/\\d{4})")
            val match = regex.find(description)
            match?.groupValues?.get(1)
        } catch (e: Exception) {
            null
        }
    }

    private fun parseMarketValueFromProfile(value: Any?): Double {
        if (value == null) return 0.0
        
        val valueStr = when (value) {
            is Number -> {
                val d = value.toDouble()
                return if (d > 0 && d < 1000) d * 1_000_000.0 else d
            }
            is String -> value
            is Map<*, *> -> value["current"] as? String ?: value["display"] as? String ?: value["value"]?.toString()
            else -> value.toString()
        }

        if (valueStr == null || valueStr.isEmpty() || valueStr == "N/A") return 0.0
        val cleanStr = valueStr.replace("€", "").trim().lowercase()
        val hasM = cleanStr.contains("m")
        val hasK = cleanStr.contains("k")

        var normalizedStr = cleanStr.replace("m", "").replace("k", "").replace(" ", "")
        if (normalizedStr.contains(",") && !normalizedStr.contains(".")) {
            normalizedStr = normalizedStr.replace(",", ".")
        }
        
        val numericPart = normalizedStr.replace(Regex("[^0-9.]"), "")
        val d = numericPart.toDoubleOrNull() ?: 0.0
        
        return when {
            hasM -> if (d > 1000) d else d * 1_000_000.0
            hasK -> if (d > 1000000) d else d * 1_000.0
            else -> if (d > 0 && d < 1000) d * 1_000_000.0 else d
        }
    }

    fun toggleWatchlist(player: com.scoutapp.data.api.PlayerResponse, currentStatus: Boolean) {
        viewModelScope.launch {
            val newStatus = !currentStatus
            val tmId = player.transfermarktId ?: player.tmId ?: ""
            
            if (tmId.isNotEmpty()) {
                playerDao.updateWatchlistStatusByTmId(tmId, newStatus)
            } else {
                playerDao.updateWatchlistStatus(player.id, newStatus)
            }
            
            val currentState = _uiState.value
            if (currentState is PlayerDetailState.Success) {
                _uiState.value = currentState.copy(isWatchlisted = newStatus)
            }
        }
    }

    fun ratePlayer(tmId: String, rating: Float) {
        viewModelScope.launch {
            enrichmentRepository.updatePlayerRating(tmId, rating)
            val currentState = _uiState.value
            if (currentState is PlayerDetailState.Success) {
                val currentEnriched = currentState.enrichedData ?: PlayerFullData(
                    transfermarkt = currentState.player,
                    fbref = currentState.fbrefStats,
                    apiFootball = null,
                    radar = currentState.radar
                )
                _uiState.value = currentState.copy(
                    enrichedData = currentEnriched.copy(userRating = rating)
                )
            }
        }
    }
}
