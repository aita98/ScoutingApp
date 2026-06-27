package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.scoutapp.viewmodel.ScoutingViewModel
import com.scoutapp.data.model.TransfermarktSearchResult
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip

@Composable
fun BackendScreen(
    onPlayerClick: (String) -> Unit,
    viewModel: ScoutingViewModel = hiltViewModel()
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val isOffline by viewModel.isOffline.collectAsState()
    val isBackendConnected by viewModel.isBackendConnected.collectAsState()
    val backendStatusInfo by viewModel.backendStatusInfo.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Backend Control Center",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        isOffline -> MaterialTheme.colorScheme.errorContainer
                        !isBackendConnected -> MaterialTheme.colorScheme.tertiaryContainer
                        else -> MaterialTheme.colorScheme.primaryContainer
                    }
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    val statusText = when {
                        isOffline -> "OFFLINE"
                        !isBackendConnected -> "DISCONNECTED"
                        else -> "ONLINE"
                    }
                    Text(
                        text = "Backend Status: $statusText",
                        style = MaterialTheme.typography.titleLarge
                    )

                    backendStatusInfo?.let { info ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Database: ${info["database"]}", style = MaterialTheme.typography.bodySmall)
                        Text("Players in DB: ${info["players_in_db"]}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }

        item {
            Button(
                onClick = { viewModel.startupBackend() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = !isLoading
            ) {
                Text("START BACKEND SERVICES")
            }
        }

        item {
            Button(
                onClick = { viewModel.resetBackendData() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("RESET DATABASE")
            }
        }

        item {
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Transfermarkt Search", style = MaterialTheme.typography.titleMedium)
        }

        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search player name...") },
                trailingIcon = {
                    IconButton(onClick = { viewModel.searchPlayers(searchQuery) }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                singleLine = true
            )
        }

        items(searchResults) { player ->
            TransfermarktPlayerItem(player) {
                onPlayerClick(player.id)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransfermarktPlayerItem(player: TransfermarktSearchResult, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = player.imageUrl,
                contentDescription = null,
                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = player.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "${player.clubName ?: "N/A"} - ${player.position ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Market Value: ${player.marketValue ?: "N/A"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
