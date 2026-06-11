package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.scoutapp.data.api.LeagueResponse
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.model.TransfermarktCompetition
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val tmApiService: TransfermarktApiService,
    private val scoutApiService: ScoutApiService
) : ViewModel() {
    private val _leagues = MutableStateFlow<List<TransfermarktCompetition>>(emptyList())
    val leagues: StateFlow<List<TransfermarktCompetition>> = _leagues
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    // Top Leagues IDs for Transfermarkt
    private val topLeagueIds = listOf("IT1", "GB1", "ES1", "L1", "FR1", "NL1", "PO1")

    init {
        loadLeagues()
    }

    fun loadLeagues() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                // Fetch basic info for top leagues
                val leaguesList = mutableListOf<TransfermarktCompetition>()
                
                // For now, since there's no direct "get top leagues" endpoint that returns all at once easily,
                // we search for them or provide a curated list. 
                // A better approach is to search for common ones.
                
                // We'll search for 'Premier League' to start, but ideally we'd have a curated list
                // For simplicity and speed in this redesign, we'll hardcode the names and fetch details if needed,
                // or just use a fixed list of common ones since we know their IDs.
                
                leaguesList.add(TransfermarktCompetition("IT1", "Serie A", "Italy", null))
                leaguesList.add(TransfermarktCompetition("GB1", "Premier League", "England", null))
                leaguesList.add(TransfermarktCompetition("ES1", "LaLiga", "Spain", null))
                leaguesList.add(TransfermarktCompetition("L1", "Bundesliga", "Germany", null))
                leaguesList.add(TransfermarktCompetition("FR1", "Ligue 1", "France", null))
                
                _leagues.value = leaguesList
            } catch (e: Exception) {
                _error.value = "Failed to load leagues: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun syncLeague(leagueId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                scoutApiService.syncLeague(leagueId)
            } catch (e: Exception) {
                _error.value = "Sync failed: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaguesScreen(
    onLeagueClick: (String) -> Unit,
    viewModel: LeaguesViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val leagues by viewModel.leagues.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Leagues",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        if (loading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (error != null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = error!!, color = MaterialTheme.colorScheme.error)
                    Button(onClick = { viewModel.loadLeagues() }) {
                        Text("Retry")
                    }
                }
            }
        } else {
            LazyColumn {
                items(leagues) { league ->
                    Card(
                        onClick = { onLeagueClick(league.id) },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = league.name, style = MaterialTheme.typography.titleMedium)
                                Text(text = league.country ?: "", style = MaterialTheme.typography.bodySmall)
                            }
                            TextButton(onClick = { viewModel.syncLeague(league.id) }) {
                                Text("Sync")
                            }
                        }
                    }
                }
            }
        }
    }
}
