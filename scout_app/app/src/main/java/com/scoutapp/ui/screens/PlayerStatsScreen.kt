package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.scoutapp.domain.model.PlayerStats
import com.scoutapp.viewmodel.PlayerStatsState
import com.scoutapp.viewmodel.PlayerStatsViewModel

import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerStatsScreen(
    playerSlug: String,
    viewModel: PlayerStatsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(playerSlug) {
        viewModel.loadPlayerStats(playerSlug)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("FBREF Advanced Analytics") })
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            when (val state = uiState) {
                is PlayerStatsState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is PlayerStatsState.Success -> {
                    FbrefStatsContent(state.stats)
                }
                is PlayerStatsState.Error -> {
                    Text(
                        text = state.message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {}
            }
        }
    }
}

@Composable
private fun FbrefStatsContent(
    stats: PlayerStats
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Season ${stats.season}",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        FbrefCoreStatsSection(stats)
        Spacer(modifier = Modifier.height(16.dp))
        FbrefAdvancedMetricsSection(stats)
        Spacer(modifier = Modifier.height(16.dp))
        FbrefDefensiveSection(stats)
    }
}

@Composable
private fun FbrefCoreStatsSection(stats: PlayerStats) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        StatCard("Goals", "${stats.goals}", Modifier.weight(1f))
        StatCard("Assists", "${stats.assists}", Modifier.weight(1f))
        StatCard("Minutes", "${stats.minutes}", Modifier.weight(1f))
    }
}

@Composable
private fun FbrefAdvancedMetricsSection(stats: PlayerStats) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Attacking & Creative", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            MetricRow("Expected Goals (xG)", String.format(Locale.getDefault(), "%.2f", stats.xG))
            MetricRow("Expected Assists (xA)", String.format(Locale.getDefault(), "%.2f", stats.xA))
            MetricRow("Key Passes", "${stats.keyPasses}")
            MetricRow("Prog. Passes", "${stats.progressivePasses}")
            MetricRow("Prog. Carries", "${stats.progressiveCarries}")
        }
    }
}

@Composable
private fun FbrefDefensiveSection(stats: PlayerStats) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Defensive Metrics", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.secondary)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            MetricRow("Pressures", "${stats.pressures}")
        }
    }
}

@Composable
private fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = label, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
private fun MetricRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Text(text = value, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
    }
}
