package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.*
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.local.PlayerEntity
import com.scoutapp.data.model.*
import com.scoutapp.data.repository.EnrichmentRepository
import com.scoutapp.domain.repository.PlayerRepository
import com.scoutapp.domain.model.PlayerStats
import com.scoutapp.utils.CompetitionDecoder
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PlayerDetailState {
    object Loading : PlayerDetailState()
    data class Success(
        val player: PlayerResponse,
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
        val tmPerformance: List<CompetitionPerformance> = emptyList(),
        val competitionStats: CompetitionStatsResponse? = null,
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
            _uiState.value = PlayerDetailState.Loading
            android.util.Log.d("API_DEBUG", "[START] Loading player: $idString (forceRefresh=$forceRefresh)")

            try {
                // 1. DATABASE CACHE CHECK (IF NOT FORCED)
                if (!forceRefresh) {
                    val cached = playerDao.getPlayerByTmId(idString) ?: (if (idString.toLongOrNull() != null) playerDao.getPlayerById(idString.toLong()) else null)
                    if (cached != null) {
                        android.util.Log.d("API_DEBUG", "[HIT] Restoring from local DB for $idString")
                        val cachedPlayerRes = com.scoutapp.data.api.PlayerResponse(
                            id = cached.id,
                            transfermarktId = cached.tmId,
                            tmId = cached.tmId,
                            name = cached.name,
                            club = cached.club,
                            league = cached.league,
                            age = cached.age,
                            marketValue = cached.marketValue,
                            position = cached.position,
                            photoUrl = cached.photoUrl,
                            isRetired = cached.isRetired,
                            statistics = if (!cached.seasonalStats.isNullOrEmpty()) gson.fromJson(cached.seasonalStats, object : TypeToken<List<SeasonStats>>() {}.type) else emptyList()
                        )
                        _uiState.value = PlayerDetailState.Success(
                            player = cachedPlayerRes,
                            isWatchlisted = cached.isWatchlisted,
                            tmTransfers = if (!cached.transfers.isNullOrEmpty() && cached.transfers != "null") runCatching { gson.fromJson<List<TransfermarktTransfer>>(cached.transfers, object : TypeToken<List<TransfermarktTransfer>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            tmInjuries = if (!cached.injuries.isNullOrEmpty() && cached.injuries != "null") runCatching { gson.fromJson<List<TransfermarktInjury>>(cached.injuries, object : TypeToken<List<TransfermarktInjury>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            tmAchievements = if (!cached.achievements.isNullOrEmpty() && cached.achievements != "null") runCatching { gson.fromJson<List<TransfermarktAchievement>>(cached.achievements, object : TypeToken<List<TransfermarktAchievement>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            tmMarketValueHistory = if (!cached.marketValueHistory.isNullOrEmpty() && cached.marketValueHistory != "null") runCatching { gson.fromJson<List<TransfermarktMarketValuePoint>>(cached.marketValueHistory, object : TypeToken<List<TransfermarktMarketValuePoint>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            tmDetailedStats = if (!cached.detailedStats.isNullOrEmpty() && cached.detailedStats != "null") runCatching { gson.fromJson<List<TransfermarktDetailedStat>>(cached.detailedStats, object : TypeToken<List<TransfermarktDetailedStat>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            citizenship = if (!cached.citizenship.isNullOrEmpty() && cached.citizenship != "null") runCatching { gson.fromJson<List<String>>(cached.citizenship, object : TypeToken<List<String>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            foot = cached.foot,
                            shirtNumber = cached.shirtNumber,
                            contractExpires = cached.contractExpires,
                            birthDate = cached.birthDate,
                            recentMatches = if (!cached.recentPerformanceJson.isNullOrEmpty() && cached.recentPerformanceJson != "null") runCatching { gson.fromJson<List<RecentMatch>>(cached.recentPerformanceJson, object : TypeToken<List<RecentMatch>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            tmPerformance = if (!cached.performanceGameJson.isNullOrEmpty() && cached.performanceGameJson != "null") runCatching { gson.fromJson<List<CompetitionPerformance>>(cached.performanceGameJson, object : TypeToken<List<CompetitionPerformance>>() {}.type) }.getOrNull() ?: emptyList() else emptyList(),
                            selectedSeason = cached.season ?: "25/26",
                            competitionStats = if (!cached.competitionStatsJson.isNullOrEmpty() && cached.competitionStatsJson != "null") runCatching { gson.fromJson<CompetitionStatsResponse>(cached.competitionStatsJson, CompetitionStatsResponse::class.java) }.getOrNull() else null,
                            radar = if (!cached.radarData.isNullOrEmpty() && cached.radarData != "null") runCatching { gson.fromJson<RadarResponse>(cached.radarData, RadarResponse::class.java) }.getOrNull() else null
                        )
                        if (System.currentTimeMillis() - cached.lastUpdated < 86400000) {
                            android.util.Log.d("API_DEBUG", "[FRESH] Cache is valid (age < 1d), skipping network")
                            return@launch 
                        }
                        android.util.Log.d("API_DEBUG", "[OLD] Cache found but outdated, refreshing from network...")
                    }
                }

                // 2. PARALLEL FETCH (ASYNC)
                android.util.Log.d("API_DEBUG", "[DISPATCH] Starting all parallel requests for $idString")
                val enrichmentDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { enrichmentRepository.getFullPlayerData(0L, idString) }.getOrNull() }
                val backendDetailDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { apiService.getPlayerDetail(idString) }.getOrNull() }
                val transfersDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerTransfers(idString).transfers }.getOrNull() }
                val injuriesDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerInjuries(idString).injuries }.getOrNull() }
                val achievementsDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerAchievements(idString).achievements }.getOrNull() }
                val historyDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerMarketValue(idString).history }.getOrNull() }
                val detailedDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerDetailedStats(idString) }.getOrNull() }
                val profileDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerProfile(idString) }.getOrNull() }
                val jerseyDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { tmApiService.getPlayerJerseyNumbers(idString).jerseyNumbers }.getOrNull() }
                val performanceDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { apiService.getPlayerPerformance(idString) }.getOrNull() }
                val radarDef = async(kotlinx.coroutines.Dispatchers.IO) { runCatching { apiService.getPlayerRadar(idString) }.getOrNull() }
                
                val performanceGameDef = async(kotlinx.coroutines.Dispatchers.IO) {
                    android.util.Log.d("PERF_DEBUG", "-> Starting DIRECT WEBSITE PERFORMANCE request for $idString")
                    runCatching { 
                        val url = "https://tmapi.transfermarkt.technology/player/$idString/performance-game"
                        val client = okhttp3.OkHttpClient.Builder().connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS).readTimeout(30, java.util.concurrent.TimeUnit.SECONDS).build()
                        val request = okhttp3.Request.Builder().url(url)
                            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:152.0) Gecko/20100101 Firefox/152.0")
                            .addHeader("Accept", "application/json").addHeader("Accept-Language", "en-US")
                            .addHeader("Referer", "https://www.transfermarkt.it/").addHeader("Origin", "https://www.transfermarkt.it")
                            .addHeader("Connection", "keep-alive").addHeader("Sec-Fetch-Dest", "empty").addHeader("Sec-Fetch-Mode", "cors").addHeader("Sec-Fetch-Site", "cross-site").build()
                        client.newCall(request).execute().use { response ->
                            android.util.Log.d("PERF_DEBUG", "Direct website response code for $idString: ${response.code}")
                            if (!response.isSuccessful) return@runCatching null
                            val body = response.body?.string()
                            android.util.Log.d("PERF_DEBUG", "Direct website body received, length: ${body?.length ?: 0}")
                            gson.fromJson(body, TransfermarktMatchLogResponse::class.java)
                        }
                    }.onFailure {
                        android.util.Log.e("PERF_DEBUG", "CRITICAL: Exception in direct request for $idString: ${it.message}", it)
                    }.getOrNull()
                }

                // 3. WAIT FOR ALL (AWAIT)
                android.util.Log.d("API_DEBUG", "[AWAIT] Waiting for all parallel requests...")
                val playerResponse = backendDetailDef.await()
                val tmTransfers = transfersDef.await() ?: emptyList()
                val tmInjuries = injuriesDef.await() ?: emptyList()
                val tmAchievements = achievementsDef.await() ?: emptyList()
                val tmHistory = historyDef.await() ?: emptyList()
                val tmProfile = profileDef.await()
                val tmDetailedResponse = detailedDef.await()
                val tmDetailed = tmDetailedResponse?.stats ?: emptyList()
                val tmJersey = jerseyDef.await() ?: emptyList()
                val tmPerformanceResponse = performanceGameDef.await()
                val radarResponse = radarDef.await()
                val competitionStats = performanceDef.await()
                val enrichedData = enrichmentDef.await()
                android.util.Log.d("API_DEBUG", "[AWAIT] All parallel requests completed")

                if (playerResponse == null && tmProfile == null) {
                    _uiState.value = PlayerDetailState.Error("Player data unavailable for: $idString")
                    return@launch
                }

                val tmId = tmProfile?.id ?: playerResponse?.tmId ?: playerResponse?.transfermarktId ?: idString
                val basePlayer = playerResponse ?: com.scoutapp.data.api.PlayerResponse(
                    id = 0L, transfermarktId = tmId, tmId = tmId, name = tmProfile?.name ?: "Unknown",
                    club = tmProfile?.club?.name, age = tmProfile?.age ?: calculateAgeFromDescription(tmProfile?.description),
                    marketValue = parseMarketValueFromProfile(tmProfile?._marketValue), marketValueDisplay = tmProfile?.marketValue,
                    position = tmProfile?.position?.main, photoUrl = tmProfile?.imageUrl, isRetired = tmProfile?.isRetired ?: false
                )

                val finalPlayer = basePlayer.copy(
                    photoUrl = basePlayer.photoUrl ?: tmProfile?.imageUrl,
                    age = basePlayer.age ?: calculateAgeFromDescription(tmProfile?.description),
                    marketValue = if (basePlayer.marketValue == null || basePlayer.marketValue == 0.0) parseMarketValueFromProfile(tmProfile?._marketValue) else basePlayer.marketValue
                )

                // 4. PROCESS COMPETITION STATS (RIEMPIMENTO DB)
                val finalCompStats = if (competitionStats != null && competitionStats.competitions?.isNotEmpty() == true) {
                    android.util.Log.d("PERF_DEBUG", "Using BACKEND Competition Stats")
                    competitionStats
                } else if (tmPerformanceResponse != null) {
                    android.util.Log.d("PERF_DEBUG", "Building Competition Stats from Website Match Log (Filtering 25/26)")
                    val perfList = tmPerformanceResponse.data?.performance ?: tmPerformanceResponse.performance ?: emptyList()
                    
                    val currentSeasonFilter = "25/26"
                    val seenGames = mutableSetOf<String>()
                    
                    val filteredPerf = perfList.filter { m ->
                        val gameId = m.gameInformation?.gameId ?: return@filter false
                        if (seenGames.contains(gameId)) return@filter false
                        
                        val seasonName = m.gameInformation?.season?.nonCyclicalName
                        // Also check if seasonId matches a typical mapping for 25/26 if needed, but nonCyclicalName is more direct
                        val isCorrectSeason = seasonName?.contains(currentSeasonFilter) == true
                        
                        val playedMins = m.playingTimeStatistics?.playedMinutes ?: m.statistics?.playingTimeStatistics?.playedMinutes ?: 0
                        
                        if (isCorrectSeason && playedMins > 0) {
                            seenGames.add(gameId)
                            true
                        } else false
                    }

                    val grouped = filteredPerf.groupBy { it.gameInformation?.competitionId ?: "Unknown" }
                    val compMap = grouped.mapValues { (compId, matches) ->
                        CompetitionData(
                            competitionName = CompetitionDecoder.decode(compId),
                            games = matches.map { m ->
                            GameStats(
                                gameId = m.gameInformation?.gameId,
                                date = m.gameInformation?.date?.dateTimeUTC?.let { GameDate(dateTimeUTC = it, isTimeDefined = true) },
                                minutes = m.playingTimeStatistics?.playedMinutes ?: m.statistics?.playingTimeStatistics?.playedMinutes,
                                isStarting = m.playingTimeStatistics?.isStarting ?: m.statistics?.playingTimeStatistics?.isStarting,
                                goals = m.statistics?.goalStatistics?.goalsScoredTotalOfficial,
                                assists = m.statistics?.goalStatistics?.assistsOfficial,
                                yellow = m.statistics?.cardStatistics?.yellowCardGross,
                                red = m.statistics?.cardStatistics?.redCards, 
                                participationState = m.participationState ?: "played"
                            )
                        })
                    }
                    CompetitionStatsResponse(player = finalPlayer.name, season = 2025, competitions = compMap)
                } else if (tmDetailed.isNotEmpty()) {
                    android.util.Log.d("PERF_DEBUG", "Building Competition Stats from TM Detailed (Filtering latest season)")
                    
                    // Filter for 25/26 if present in detailed stats
                    val filteredStats = tmDetailed.filter { it.seasonId?.toString()?.contains("25/26") == true }
                        .ifEmpty { 
                            // Fallback to latest season if 25/26 not found explicitly
                            val latestSeasonId = tmDetailed.mapNotNull { it.seasonId?.toString() }
                                .sortedDescending()
                                .firstOrNull()
                            tmDetailed.filter { it.seasonId?.toString() == latestSeasonId }
                        }

                    val grouped = filteredStats.filter { it.competitionName != null }.groupBy { it.competitionName.toString() }
                    val compMap = grouped.mapValues { (compId, statsList) ->
                        CompetitionData(
                            competitionName = CompetitionDecoder.decode(compId),
                            games = statsList.map { s ->
                            GameStats(
                                gameId = s.competitionId?.toString(), date = null,
                                minutes = s.minutesPlayed?.toString()?.replace(".", "")?.replace("'", "")?.toIntOrNull(),
                                isStarting = null, goals = s.goals?.toString()?.toIntOrNull(),
                                assists = s.assists?.toString()?.toIntOrNull(),
                                yellow = s.yellowCards?.toString()?.toIntOrNull(),
                                red = s.redCards?.toString()?.toIntOrNull(), participationState = "played"
                            )
                        })
                    }
                    CompetitionStatsResponse(player = finalPlayer.name, season = 2024, competitions = compMap)
                } else null

                // 5. AGGREGATE RENDIMENTO TABLE (DIVISIONE COMPETIZIONI)
                val tmPerformanceGame = if (finalCompStats != null && finalCompStats.competitions != null) {
                    android.util.Log.d("PERF_DEBUG", "Aggregating RENDIMENTO from competition stats (Split mode)")
                    aggregateStatsFromCompetitionStats(finalCompStats)
                } else if (tmProfile?.stats != null && tmProfile.stats.isNotEmpty()) {
                    android.util.Log.d("PERF_DEBUG", "Aggregating RENDIMENTO from profile (Fallback)")
                    aggregateStatsByProfile(tmProfile.stats)
                } else emptyList()

                val localPlayer = if (tmId.isNotEmpty()) playerDao.getPlayerByTmId(tmId) else null
                val finalRadar = radarResponse ?: basePlayer.radar ?: RadarResponse(60, 60, 60, 60, 60, 60)
                val resolvedShirtNumber = tmJersey.firstOrNull()?.number ?: tmProfile?.shirtNumber
                val aggregatedSeasonStats = aggregateCompetitionStats(finalCompStats)
                val finalStats = if (aggregatedSeasonStats != null) listOf(aggregatedSeasonStats) else finalPlayer.statistics

                _uiState.value = PlayerDetailState.Success(
                    player = finalPlayer, radar = finalRadar, isWatchlisted = localPlayer?.isWatchlisted ?: false,
                    tmTransfers = tmTransfers, tmInjuries = tmInjuries, tmAchievements = tmAchievements,
                    tmMarketValueHistory = tmHistory, tmDetailedStats = tmDetailed, foot = tmProfile?.foot,
                    shirtNumber = resolvedShirtNumber, citizenship = tmProfile?.citizenship ?: emptyList(),
                    contractExpires = tmProfile?.club?.contractExpires, birthDate = extractBirthDate(tmProfile?.description),
                    selectedSeason = finalPlayer.season ?: "25/26", recentMatches = finalPlayer.recentMatches ?: emptyList(),
                    tmPerformance = tmPerformanceGame, competitionStats = finalCompStats, enrichedData = enrichedData
                )

                // 7. SAVE TO DB (Persistent Cache)
                playerDao.upsertPlayersPreservingLocalFields(listOf(
                    PlayerEntity(
                        id = finalPlayer.id, tmId = tmId, name = finalPlayer.name ?: "Unknown",
                        club = finalPlayer.club, league = finalPlayer.league, age = finalPlayer.age,
                        marketValue = finalPlayer.marketValue, talentScore = finalPlayer.talentScore ?: 0.0,
                        hiddenGemScore = finalPlayer.hiddenGemScore ?: 0.0, position = finalPlayer.position,
                        photoUrl = finalPlayer.photoUrl, isRetired = finalPlayer.isRetired ?: false,
                        foot = tmProfile?.foot, shirtNumber = resolvedShirtNumber,
                        citizenship = gson.toJson(tmProfile?.citizenship), contractExpires = tmProfile?.club?.contractExpires,
                        birthDate = extractBirthDate(tmProfile?.description), detailedStats = gson.toJson(tmDetailed),
                        achievements = gson.toJson(tmAchievements), marketValueHistory = gson.toJson(tmHistory),
                        transfers = gson.toJson(tmTransfers), injuries = gson.toJson(tmInjuries),
                        radarData = gson.toJson(finalRadar), recentPerformanceJson = gson.toJson(finalPlayer.recentMatches),
                        performanceGameJson = gson.toJson(tmPerformanceGame), seasonalStats = gson.toJson(finalStats),
                        competitionStatsJson = gson.toJson(finalCompStats), lastUpdated = System.currentTimeMillis()
                    )
                ))

            } catch (e: Exception) {
                android.util.Log.e("API_DEBUG", "Error loading player: ${e.message}", e)
                _uiState.value = PlayerDetailState.Error("Error: ${e.message}")
            }
        }
    }

    private fun aggregateStatsFromCompetitionStats(stats: CompetitionStatsResponse): List<CompetitionPerformance> {
        val comps = stats.competitions ?: return emptyList()
        return comps.map { (compId, data) ->
            val games = data.games ?: emptyList()
            CompetitionPerformance(
                competitionId = compId,
                competitionName = data.competitionName ?: compId,
                appearances = games.count { it.participationState == "played" || (it.minutes ?: 0) > 0 },
                goals = games.sumOf { it.goals ?: 0 },
                assists = games.sumOf { it.assists ?: 0 },
                minutesPlayed = games.sumOf { it.minutes ?: 0 },
                competitionImageUrl = data.competitionIconUrl
            )
        }.sortedByDescending { it.appearances }
    }

    private fun aggregateStatsByProfile(stats: List<TransfermarktStat>): List<CompetitionPerformance> {
        return stats.map { stat ->
            val compId = stat.competition ?: "Unknown"
            CompetitionPerformance(
                competitionId = compId,
                competitionName = CompetitionDecoder.decode(compId),
                appearances = stat.appearances?.toString()?.toIntOrNull() ?: 0,
                goals = stat.goals?.toString()?.toIntOrNull() ?: 0,
                assists = stat.assists?.toString()?.toIntOrNull() ?: 0,
                minutesPlayed = stat.minutesPlayed?.toString()?.replace(".", "")?.replace("'", "")?.toIntOrNull() ?: 0
            )
        }.sortedByDescending { it.appearances }
    }

    private fun aggregateCompetitionStats(compStats: CompetitionStatsResponse?): SeasonStats? {
        if (compStats == null || compStats.competitions.isNullOrEmpty()) return null
        var apps = 0; var goals = 0; var assists = 0; var yellow = 0; var mins = 0
        compStats.competitions.values.forEach { comp ->
            comp.games?.forEach { game ->
                if (game.participationState == "played") {
                    apps++; goals += game.goals ?: 0; assists += game.assists ?: 0; yellow += game.yellow ?: 0; mins += game.minutes ?: 0
                }
            }
        }
        return SeasonStats(appearances = apps, goals = goals, assists = assists, yellowCards = yellow, minutesPlayed = mins)
    }

    private fun calculateAgeFromDescription(desc: String?): Int? {
        if (desc == null) return null
        // Robust regex for age: looks for a number after a comma or space, often followed by ", from" or " years old"
        val regex = Regex("(?:,|\\s)\\s?(\\d{1,2})(?:,|\\s)\\s?(?:from|years|anni|old)", RegexOption.IGNORE_CASE)
        val match = regex.find(desc)
        return match?.groupValues?.get(1)?.toIntOrNull()
    }

    private fun extractBirthDate(desc: String?): String? {
        if (desc == null) return null
        // Supports "Born: Jun 29, 2026", "Nato il: 29/giu/2026", "29/06/2026"
        val dateRegex = Regex("(?:Born|Nato il|Birth):?\\s?(\\w{3}\\s\\d{1,2},\\s\\d{4}|\\d{1,2}[/-]\\d{1,2}[/-]\\d{4}|\\d{1,2}[/-]\\w{3}[/-]\\d{4})", RegexOption.IGNORE_CASE)
        val match = dateRegex.find(desc)
        if (match != null) return match.groupValues[1]
        
        // Fallback for just the date if present
        val fallbackRegex = Regex("(\\d{1,2}[/.-]\\d{1,2}[/.-]\\d{4})")
        return fallbackRegex.find(desc)?.groupValues?.get(1)
    }

    private fun parseMarketValueFromProfile(raw: Any?): Double {
        if (raw == null) return 0.0
        return when (raw) {
            is Number -> raw.toDouble()
            is String -> {
                val clean = raw.replace("€", "").trim().lowercase()
                val hasM = clean.contains("m"); val hasK = clean.contains("k")
                val numeric = clean.replace("m", "").replace("k", "").replace(" ", "").replace(",", ".").replace(Regex("[^0-9.]"), "")
                val d = numeric.toDoubleOrNull() ?: 0.0
                when { hasM -> d * 1_000_000.0; hasK -> d * 1_000.0; else -> d }
            }
            is Map<*, *> -> raw["value"]?.toString()?.toDoubleOrNull() ?: 0.0
            else -> 0.0
        }
    }

    fun toggleWatchlist(player: PlayerResponse, currentStatus: Boolean) {
        viewModelScope.launch {
            val tmId = player.transfermarktId ?: player.tmId ?: player.id.toString()
            playerDao.updateWatchlistStatusByTmId(tmId, !currentStatus)
            if (player.id != 0L) { if (!currentStatus) apiService.addToWatchlist(player.id) else apiService.removeFromWatchlist(player.id) }
            val currentState = _uiState.value
            if (currentState is PlayerDetailState.Success) _uiState.value = currentState.copy(isWatchlisted = !currentStatus)
        }
    }

    fun ratePlayer(tmId: String, rating: Float) {
        viewModelScope.launch {
            playerDao.updateRating(tmId, rating)
            val currentState = _uiState.value
            if (currentState is PlayerDetailState.Success) _uiState.value = currentState.copy(enrichedData = currentState.enrichedData?.copy(userRating = rating))
        }
    }
}
