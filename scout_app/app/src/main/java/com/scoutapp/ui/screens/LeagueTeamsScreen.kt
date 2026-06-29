package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.scoutapp.data.api.TeamResponse
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.model.TransfermarktClub
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
    private val tmApiService: TransfermarktApiService,
    private val scoutApiService: ScoutApiService,
    private val teamDao: com.scoutapp.data.local.TeamDao
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _currentLeagueId = MutableStateFlow<String?>(null)

    val displayTeams: StateFlow<List<TransfermarktClub>> = _currentLeagueId
        .filterNotNull()
        .flatMapLatest { leagueId ->
            teamDao.getTeamsByLeague(leagueId).map { entities ->
                entities.map { entity ->
                    TransfermarktClub(
                        id = entity.id,
                        name = entity.name,
                        imageUrl = entity.logoUrl
                    )
                }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun loadTeams(leagueId: String) {
        _currentLeagueId.value = leagueId
        
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                val teamsList = if (leagueId == "FREE" || leagueId == "FREE_AGENTS") {
                    // Virtual team for Free Agents
                    listOf(TransfermarktClub("515", "All Free Agents", null))
                } else {
                    // Try Transfermarkt API first
                    val tmResult = runCatching { tmApiService.getCompetitionClubs(leagueId) }
                    
                    if (tmResult.isSuccess) {
                        tmResult.getOrThrow().clubs
                    } else {
                        // Fallback: If it's a numeric ID, it might be from our backend
                        val numericId = leagueId.toLongOrNull()
                        if (numericId != null) {
                            scoutApiService.getTeams(numericId).map { 
                                TransfermarktClub(it.id.toString(), it.name, it.logoUrl)
                            }
                        } else {
                            throw tmResult.exceptionOrNull() ?: Exception("Unknown error")
                        }
                    }
                }

                // Save to DB
                if (teamsList.isNotEmpty()) {
                    teamDao.insertTeams(teamsList.map { 
                        com.scoutapp.data.local.TeamEntity(
                            id = it.id,
                            name = it.name,
                            leagueId = leagueId,
                            logoUrl = it.imageUrl
                        )
                    })
                } else {
                    android.util.Log.w("LEAGUE_TEAMS", "No teams found for league $leagueId")
                }
            } catch (e: Exception) {
                android.util.Log.e("LEAGUE_TEAMS", "Error loading teams for $leagueId", e)
                // Only show error if we have no cached data
                if (displayTeams.value.isEmpty()) {
                    _error.value = "Failed to load teams: ${e.message}"
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeagueTeamsScreen(
    leagueId: String,
    onTeamClick: (String) -> Unit,
    viewModel: LeagueTeamsViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val teams by viewModel.displayTeams.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(leagueId) {
        viewModel.loadTeams(leagueId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Teams", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (loading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (error != null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = error!!, color = MaterialTheme.colorScheme.error)
                    Button(onClick = { viewModel.loadTeams(leagueId) }) {
                        Text("Retry")
                    }
                }
            }
        } else {
            LazyColumn {
                items(teams) { team ->
                    Card(
                        onClick = { onTeamClick(team.id) },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val isCached = true // Now all teams in displayTeams are from DB
                            if (isCached) {
                                Icon(
                                    Icons.Default.Storage,
                                    contentDescription = "Cached",
                                    tint = MaterialTheme.colorScheme.tertiary,
                                    modifier = Modifier.size(20.dp).padding(end = 12.dp)
                                )
                            }
                            Column {
                                Text(text = team.name, style = MaterialTheme.typography.titleMedium)
                            }
                        }
                    }
                }
            }
        }
    }
}
