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

@Composable
fun BackendScreen(
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
                        isOffline -> "OFFLINE (No Internet)"
                        !isBackendConnected -> "BACKEND UNREACHABLE"
                        else -> "ONLINE (Connected)"
                    }
                    Text(
                        text = "Status: $statusText",
                        style = MaterialTheme.typography.titleLarge
                    )
                    val descriptionText = when {
                        isOffline -> "Controlla la tua connessione internet."
                        !isBackendConnected -> "Il dispositivo è connesso a internet, ma non riesce a raggiungere il backend su ZeroTier (172.24.36.58). Verifica che ZeroTier sia attivo."
                        else -> "Connesso correttamente al backend ZeroTier."
                    }
                    Text(
                        text = descriptionText,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    backendStatusInfo?.let { info ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider(color = Color.White.copy(alpha = 0.2f))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Dettagli Real-time:", style = MaterialTheme.typography.labelMedium)
                        Text("Database: ${info["database"]}", style = MaterialTheme.typography.bodySmall)
                        Text("Giocatori nel DB: ${info["players_in_db"]}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }

        item {
            Button(
                onClick = { viewModel.startupBackend() },
                modifier = Modifier.fillMaxWidth().height(64.dp),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp), color = Color.White)
                } else {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.PowerSettingsNew, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("START BACKEND SERVICES")
                    }
                }
            }
        }

        item {
            OutlinedButton(
                onClick = { viewModel.triggerSync() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = !isLoading
            ) {
                Text("Sincronizzazione Campionati (Sync)")
            }
        }

        item {
            Button(
                onClick = { viewModel.resetBackendData() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("RESET DATABASE BACKEND")
            }
        }

        item {
            Button(
                onClick = { viewModel.loadAllData() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text("Verifica Connessione Backend")
            }
        }

        if (error != null) {
            item {
                Text(text = error!!, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            }
        }

        item {
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = "Transfermarkt Search (Alternative)",
                style = MaterialTheme.typography.titleMedium
            )
        }

        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search player on Transfermarkt...") },
                trailingIcon = {
                    IconButton(onClick = { viewModel.searchPlayers(searchQuery) }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                singleLine = true
            )
        }

        items(searchResults) { player ->
            TransfermarktPlayerItem(player)
        }
        
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Target IP: 172.24.36.58:8080\nTM API: transfermarkt-api.fly.dev",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun TransfermarktPlayerItem(player: TransfermarktSearchResult) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = player.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "${player.club ?: "N/A"} - ${player.position ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Value: ${player.marketValue ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
