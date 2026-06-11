package com.scoutapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.scoutapp.ui.components.PlayerCard
import com.scoutapp.viewmodel.AIScoutUiState
import com.scoutapp.viewmodel.AIScoutViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AIScoutScreen(
    viewModel: AIScoutViewModel = hiltViewModel(),
    onPlayerClick: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "AI Scouting Assistant",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Describe player profile (e.g. young winger, fast...)") },
            placeholder = { Text("Winger under 21 with high dribbling and low minutes") },
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.performAIScout(searchQuery) },
            modifier = Modifier.fillMaxWidth(),
            enabled = searchQuery.isNotBlank() && uiState !is AIScoutUiState.Loading,
            shape = RoundedCornerShape(12.dp)
        ) {
            if (uiState is AIScoutUiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp), color = Color.White)
            } else {
                Text("Analyze with AI")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        when (val state = uiState) {
            is AIScoutUiState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        AIScoutResultCard(state.data.scoutingReport, state.data.recommendations)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Similar Players",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    items(state.data.similarPlayers) { player ->
                        PlayerCard(
                            name = player.name,
                            club = player.club,
                            score = player.similarityScore.toDouble(),
                            onClick = { onPlayerClick(player.id.toString()) }
                        )
                    }
                }
            }
            is AIScoutUiState.Error -> {
                Text(text = "Error: ${state.message}", color = MaterialTheme.colorScheme.error)
            }
            else -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Ask AI to find hidden gems or analyze specific profiles.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun AIScoutResultCard(report: String, recommendations: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Scouting Report",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = report, style = MaterialTheme.typography.bodyMedium)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "AI Recommendations",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = recommendations, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
