package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
    private val tmApiService: TransfermarktApiService
) : ViewModel() {
    private val _teams = MutableStateFlow<List<TransfermarktClub>>(emptyList())
    val teams: StateFlow<List<TransfermarktClub>> = _teams
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadTeams(leagueId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                if (leagueId == "FREE") {
                    _teams.value = listOf(TransfermarktClub("515", "All Free Agents", null))
                } else {
                    val response = tmApiService.getCompetitionClubs(leagueId)
                    _teams.value = response.clubs
                }
            } catch (e: Exception) {
                _error.value = "Failed to load teams: ${e.message}"
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
    val teams by viewModel.teams.collectAsState()
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
                        Row(modifier = Modifier.padding(16.dp)) {
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
