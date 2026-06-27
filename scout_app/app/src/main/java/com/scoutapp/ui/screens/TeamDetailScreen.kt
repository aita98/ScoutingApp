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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val tmApiService: TransfermarktApiService,
    private val scoutApiService: ScoutApiService
) : ViewModel() {
    private val _players = MutableStateFlow<List<PlayerResponse>>(emptyList())
    val players: StateFlow<List<PlayerResponse>> = _players
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadTeamPlayers(teamId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                if (teamId == "FREE") {
                    val backendPlayers = try { 
                        scoutApiService.getOneToWatch() + scoutApiService.getHiddenGems()
                    } catch (e: Exception) {
                        emptyList()
                    }
                    _players.value = backendPlayers.distinctBy { it.tmId ?: it.id.toString() }
                } else {
                    // Reverted to Transfermarkt for squad listing
                    val response = tmApiService.getClubPlayers(teamId)
                    val mappedPlayers = response.players?.map { p ->
                        PlayerResponse(
                            id = 0L,
                            transfermarktId = p.id,
                            tmId = p.id,
                            fbrefSlug = null,
                            name = p.name,
                            club = null, // Team context already known
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
                    _players.value = mappedPlayers
                }
            } catch (e: Exception) {
                _error.value = "Failed to load players: ${e.message}"
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
    val players by viewModel.players.collectAsState()
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
                        score = player.talentScore ?: 0.0,
                        onClick = { 
                            onPlayerClick(player.tmId ?: player.id.toString())
                        }
                    )
                }
            }
        }
    }
}
