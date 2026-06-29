package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.ui.components.PlayerCard
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val tmApiService: TransfermarktApiService,
    private val scoutApiService: ScoutApiService,
    private val playerDao: com.scoutapp.data.local.PlayerDao
) : ViewModel() {
    private val _players = MutableStateFlow<List<PlayerResponse>>(emptyList())
    val players: StateFlow<List<PlayerResponse>> = _players
    
    private val _dbPlayers = MutableStateFlow<List<PlayerResponse>>(emptyList())

    val displayPlayers = combine(_players, _dbPlayers) { tm, db ->
        (tm + db).distinctBy { it.tmId ?: it.id.toString() }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadTeamPlayers(teamId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            // Observe DB players for this team
            playerDao.getPlayersInClub(teamId)
                .onEach { entities ->
                    _dbPlayers.value = entities.map { entity ->
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
                            isHiddenGem = entity.hiddenGemScore > 0,
                            isConsigliato = entity.talentScore > 0
                        )
                    }
                }.launchIn(viewModelScope)

            try {
                // Step 1: Fetch raw squad data
                val tmPlayers = if (teamId == "FREE_AGENTS" || teamId == "FREE" || teamId == "515") {
                    // Try to fetch from Backend first, fallback to mock/empty if needed
                    try {
                        scoutApiService.getTeamPlayers("FREE").map { p ->
                             PlayerResponse(
                                id = p.id,
                                transfermarktId = p.tmId,
                                tmId = p.tmId,
                                name = p.name,
                                club = "Free Agent",
                                age = p.age,
                                marketValue = p.marketValue,
                                talentScore = p.talentScore,
                                hiddenGemScore = p.hiddenGemScore,
                                position = p.position,
                                photoUrl = p.photoUrl,
                                isRetired = false,
                                matchesPlayed = p.matchesPlayed,
                                appearances = p.appearances
                            )
                        }
                    } catch (e: Exception) {
                        // If backend fails for FREE, we might need a specific handling or scraper
                        emptyList()
                    }
                } else {
                    val tmResponse = tmApiService.getClubPlayers(teamId)
                    tmResponse.players?.map { p ->
                        PlayerResponse(
                            id = 0L,
                            transfermarktId = p.id,
                            tmId = p.id,
                            fbrefSlug = null,
                            name = p.name,
                            club = null,
                            age = p.age,
                            marketValue = parseMarketValue(p.marketValue),
                            marketValueDisplay = p.marketValue,
                            talentScore = null,
                            hiddenGemScore = null,
                            position = p.position,
                            photoUrl = p.imageUrl,
                            isRetired = false,
                            statistics = null,
                            radar = null
                        )
                    } ?: emptyList()
                }

                // Step 2: Fetch enrichment data from LOCAL DB
                val localEnrichment = playerDao.getAllPlayers().first().map { entity ->
                    PlayerResponse(
                        id = entity.id,
                        tmId = entity.tmId,
                        transfermarktId = entity.tmId,
                        name = entity.name,
                        club = entity.club,
                        talentScore = entity.talentScore,
                        hiddenGemScore = entity.hiddenGemScore,
                        isHiddenGem = entity.hiddenGemScore > 0,
                        isConsigliato = entity.talentScore > 0
                    )
                }

                // Step 3: Merge data
                val enrichedMap = localEnrichment.associateBy { it.tmId ?: it.id.toString() }
                
                val finalPlayers = tmPlayers.map { p ->
                    val enrichment = enrichedMap[p.tmId]
                    if (enrichment != null) {
                        p.copy(
                            id = enrichment.id,
                            talentScore = enrichment.talentScore,
                            hiddenGemScore = enrichment.hiddenGemScore,
                            club = enrichment.club ?: p.club,
                            isHiddenGem = enrichment.isHiddenGem,
                            isConsigliato = enrichment.isConsigliato
                        )
                    } else {
                        p
                    }
                }

                _players.value = finalPlayers
            } catch (e: Exception) {
                if (_dbPlayers.value.isEmpty()) {
                    _error.value = "Failed to load players: ${e.message}"
                }
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun parseMarketValue(valueStr: String?): Double {
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
}

@Composable
fun TeamDetailScreen(
    teamId: String,
    onPlayerClick: (String) -> Unit,
    viewModel: TeamDetailViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val players by viewModel.displayPlayers.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(teamId) {
        viewModel.loadTeamPlayers(teamId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Squad Members (TM)", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (loading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (error != null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = error!!, color = MaterialTheme.colorScheme.error)
                    Button(onClick = { viewModel.loadTeamPlayers(teamId) }) {
                        Text("Retry")
                    }
                }
            }
        } else {
            LazyColumn {
                items(players) { player ->
                    PlayerCard(
                        name = player.name ?: "N/A",
                        club = player.club ?: "",
                        score = (player.talentScore ?: player.hiddenGemScore) ?: 0.0,
                        isGem = player.isHiddenGem == true,
                        onClick = { 
                            onPlayerClick(player.tmId ?: player.id.toString())
                        }
                    )
                }
            }
        }
    }
}
