package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.scoutapp.ui.components.RadarChart
import com.scoutapp.ui.components.RadarData

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.scoutapp.viewmodel.PlayerDetailState
import com.scoutapp.viewmodel.PlayerDetailViewModel
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerDetailScreen(
    playerId: String,
    viewModel: PlayerDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(playerId) {
        viewModel.loadPlayer(playerId)
    }

    when (val currentState = state) {
        is PlayerDetailState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is PlayerDetailState.Success -> {
            val player = currentState.player
            val radar = currentState.radar
            val isWatchlisted = currentState.isWatchlisted
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                // Player Photo
                AsyncImage(
                    model = player.photoUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = player.name ?: "N/A",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${player.club ?: "N/A"} | ${player.position ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(8.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SuggestionChip(
                        onClick = { },
                        label = { Text("Età: ${player.age ?: "?"}") }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    SuggestionChip(
                        onClick = { },
                        label = { Text("Valore: ${formatMarketValue(player.marketValue)}") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Season Stats
                player.seasonStats?.let { stats ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Current Season Stats",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                                StatItem("Apps", stats.appearances.toString())
                                StatItem("Goals", stats.goals.toString())
                                StatItem("Assists", stats.assists.toString())
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                                StatItem("Mins", stats.minutesPlayed.toString())
                                StatItem("Yellow", stats.yellowCards.toString())
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Technical Profile",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        RadarChart(
                            data = RadarData(
                                labels = listOf("Pace", "Shooting", "Passing", "Dribbling", "Physical", "Intelligence"),
                                values = listOf(
                                    radar.pace.toFloat(), 
                                    radar.shooting.toFloat(), 
                                    radar.passing.toFloat(), 
                                    radar.dribbling.toFloat(), 
                                    radar.physical.toFloat(), 
                                    radar.intelligence.toFloat()
                                )
                            ),
                            modifier = Modifier
                                .size(300.dp)
                                .align(androidx.compose.ui.Alignment.CenterHorizontally)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { viewModel.toggleWatchlist(player, isWatchlisted) }, 
                        modifier = Modifier.weight(1f).padding(end = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isWatchlisted) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(if (isWatchlisted) "Remove" else "Add Watchlist")
                    }

                    OutlinedButton(
                        onClick = { viewModel.forceRefresh(player.id, null) },
                        modifier = Modifier.weight(1f).padding(start = 4.dp)
                    ) {
                        Text("Refresh Stats")
                    }
                }
            }
        }
        is PlayerDetailState.Error -> {
            Text("Error: ${currentState.message}")
        }
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text(text = label, style = MaterialTheme.typography.labelSmall)
    }
}

fun formatMarketValue(value: Double?): String {
    if (value == null || value == 0.0) return "N/A"
    return if (value >= 1_000_000) {
        String.format("%.1fM€", value / 1_000_000.0)
    } else {
        String.format("%.0fK€", value / 1_000.0)
    }
}

@Composable
fun StatsRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Text(text = value, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
    }
}
