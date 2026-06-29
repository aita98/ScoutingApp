package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.ScoutApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.scoutapp.ui.components.PlayerCard

// --- DATA MODELS ---

data class Player(
    val id: Long,
    val name: String,
    val position: String,
    val age: Int,
    val club: String,
    val league: String,
    val marketValue: String,
    val transfermarktId: String,
    val photoUrl: String? = null,
    val talentScore: Double? = 0.0,
    val hiddenGemScore: Double? = 0.0,
    val stats: PlayerStats? = null
)

data class PlayerStats(
    val appearances: Int,
    val goals: Int,
    val assists: Int
)

// --- VIEWMODEL ---

@HiltViewModel
class PlayerListViewModel @Inject constructor(
    private val scoutApiService: ScoutApiService
) : ViewModel() {
    
    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players: StateFlow<List<Player>> = _players

    private val _filteredPlayers = MutableStateFlow<List<Player>>(emptyList())
    val filteredPlayers: StateFlow<List<Player>> = _filteredPlayers

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedSeason = MutableStateFlow("2025")
    val selectedSeason: StateFlow<String> = _selectedSeason

    init {
        loadPlayers()
    }

    fun loadPlayers() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val apiPlayers = scoutApiService.getPlayersFromDb()
                val mapped = apiPlayers.map { p ->
                    Player(
                        id = p.id,
                        name = p.name ?: "Unknown",
                        position = p.position ?: "N/A",
                        age = p.age ?: 0,
                        club = p.club ?: "N/A",
                        league = p.league ?: "N/A",
                        marketValue = p.marketValueDisplay ?: "N/A",
                        transfermarktId = p.transfermarktId ?: "",
                        photoUrl = p.photoUrl,
                        talentScore = p.talentScore,
                        hiddenGemScore = p.hiddenGemScore,
                        stats = p.statistics?.firstOrNull()?.let { s ->
                            PlayerStats(
                                appearances = s.appearances ?: 0,
                                goals = s.goals ?: 0,
                                assists = s.assists ?: 0
                            )
                        }
                    )
                }
                _players.value = mapped
                filterPlayers(_searchQuery.value)
            } catch (e: Exception) {
                // Error handling
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        filterPlayers(query)
    }

    private fun filterPlayers(query: String) {
        if (query.isBlank()) {
            _filteredPlayers.value = _players.value
        } else {
            _filteredPlayers.value = _players.value.filter {
                it.name.contains(query, ignoreCase = true) ||
                it.club.contains(query, ignoreCase = true) ||
                it.league.contains(query, ignoreCase = true)
            }
        }
    }

    fun setSeason(season: String) {
        _selectedSeason.value = season
    }

    fun triggerSync() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                scoutApiService.startupBackend(_selectedSeason.value)
                loadPlayers() // Reload after triggering sync
            } catch (e: Exception) {
                // Error handling
            } finally {
                _isLoading.value = false
            }
        }
    }
}

// --- UI COMPONENTS ---

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedPlayersScreen(
    viewModel: PlayerListViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val players by viewModel.filteredPlayers.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedSeason by viewModel.selectedSeason.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Database Giocatori Salvati", fontWeight = FontWeight.Bold) },
                actions = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Stagione:", fontSize = 14.sp)
                        Spacer(Modifier.width(8.dp))
                        SeasonSelector(selectedSeason) { viewModel.setSeason(it) }
                        IconButton(onClick = { viewModel.triggerSync() }) {
                            Icon(Icons.Default.Sync, contentDescription = "Sincronizza")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.onSearchQueryChange(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Cerca per nome, club o campionato...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                shape = MaterialTheme.shapes.medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading && players.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(players) { player ->
                        PlayerCard(
                            name = player.name,
                            club = player.club,
                            score = (player.talentScore ?: player.hiddenGemScore) ?: 0.0,
                            age = player.age,
                            marketValue = player.marketValue,
                            photoUrl = player.photoUrl,
                            isGem = (player.hiddenGemScore ?: 0.0) > 0,
                            isTalent = (player.talentScore ?: 0.0) > 0,
                            onClick = { /* Handle click if needed, or link to detail */ }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SavedPlayerCard(player: Player) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = player.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${player.position} • ${player.age} anni",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
                Text(
                    text = player.marketValue,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${player.club} - ${player.league}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Stats Summary
            player.stats?.let { stats ->
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        SavedStatItem("Presenze", stats.appearances.toString())
                        SavedStatItem("Gol", stats.goals.toString())
                        SavedStatItem("Assist", stats.assists.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun SavedStatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
fun SeasonSelector(selected: String, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val seasons = listOf("2024", "2025")

    Box {
        TextButton(onClick = { expanded = true }) {
            Text(selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            seasons.forEach { season ->
                DropdownMenuItem(
                    text = { Text(season) },
                    onClick = {
                        onSelect(season)
                        expanded = false
                    }
                )
            }
        }
    }
}
