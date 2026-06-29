package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.model.TransfermarktCompetition
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val tmApiService: TransfermarktApiService,
    private val scoutApiService: ScoutApiService,
    private val leagueDao: com.scoutapp.data.local.LeagueDao
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    val displayLeagues: StateFlow<List<TransfermarktCompetition>> = leagueDao.getAllLeagues()
        .map { entities ->
            entities.map { entity ->
                TransfermarktCompetition(
                    id = entity.id,
                    name = entity.name,
                    country = entity.country,
                    imageUrl = entity.logoUrl
                )
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        loadLeagues()
    }

    fun loadLeagues() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                // Predefined list with stable IDs
                val staticLeagues = listOf(
                    TransfermarktCompetition("IT1", "Serie A", "Italy", null),
                    TransfermarktCompetition("GB1", "Premier League", "England", null),
                    TransfermarktCompetition("ES1", "La Liga", "Spain", null),
                    TransfermarktCompetition("L1", "Bundesliga", "Germany", null),
                    TransfermarktCompetition("FR1", "Ligue 1", "France", null),
                    TransfermarktCompetition("NL1", "Eredivisie", "Netherlands", null),
                    TransfermarktCompetition("PO1", "Liga Portugal", "Portugal", null),
                    TransfermarktCompetition("BRA1", "Série A", "Brazil", null),
                    TransfermarktCompetition("FREE", "Free Agents", "Global", null),
                    TransfermarktCompetition("IT2", "Serie B", "Italy", null),
                    TransfermarktCompetition("GB2", "Championship", "England", null),
                    TransfermarktCompetition("COL1", "Serie A", "Colombia", null)
                )

                // Fetch from Scout Backend
                val remoteLeagues = try {
                    scoutApiService.getLeagues().map { 
                        TransfermarktCompetition(it.id.toString(), it.name, it.country, it.logoUrl)
                    }
                } catch (e: Exception) {
                    emptyList()
                }

                // Robust Merge Logic:
                // Use a normalized name + country as key to merge logical duplicates
                // while keeping different leagues with the same name (e.g. Serie A Italy vs Colombia)
                val mergedByKey = mutableMapOf<String, TransfermarktCompetition>()
                
                fun normalize(name: String, country: String?) = 
                    "${name.lowercase().replace(Regex("[^a-z0-9]"), "")}_${country?.lowercase()?.replace(Regex("[^a-z0-9]"), "") ?: "unknown"}"

                // Add remote first
                remoteLeagues.forEach { 
                    mergedByKey[normalize(it.name, it.country)] = it
                }
                
                // Add static second (overwriting remote with better Transfermarkt IDs like "IT1" for Serie A)
                staticLeagues.forEach { 
                    mergedByKey[normalize(it.name, it.country)] = it
                }

                val merged = mergedByKey.values.toList().sortedBy { it.name }

                // LOG for debugging
                merged.forEach { android.util.Log.d("LEAGUE_SYNC", "Final league: ${it.name} ID=${it.id}") }

                // Clear and repopulate to ensure data integrity
                leagueDao.deleteAllLeagues()
                leagueDao.insertLeagues(merged.map {
                    com.scoutapp.data.local.LeagueEntity(
                        id = it.id,
                        name = it.name,
                        country = it.country,
                        logoUrl = it.imageUrl
                    )
                })
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
    val leagues by viewModel.displayLeagues.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Leagues (Transfermarkt)",
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
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                if (league.country == "Database" || league.country == "Local Cache") {
                                    Icon(
                                        Icons.Default.Storage,
                                        contentDescription = "Cached",
                                        tint = MaterialTheme.colorScheme.tertiary,
                                        modifier = Modifier.size(20.dp).padding(end = 8.dp)
                                    )
                                }
                                Column {
                                    Text(text = league.name, style = MaterialTheme.typography.titleMedium)
                                    Text(
                                        text = if (league.country == "Database" || league.country == "Local Cache") "Sincronizzato" else league.country ?: "",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
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
