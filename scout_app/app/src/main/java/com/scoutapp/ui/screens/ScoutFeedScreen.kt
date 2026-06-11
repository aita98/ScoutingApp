package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.scoutapp.data.api.ScoutEventResponse
import androidx.compose.ui.graphics.Color

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh

@Composable
fun ScoutFeedScreen(
    events: List<ScoutEventResponse>,
    onRefresh: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text(
                text = "Scout Feed",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = onRefresh) {
                Icon(Icons.Default.Refresh, contentDescription = "Sync Data")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        if (events.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("No recent events")
            }
        } else {
            LazyColumn {
                items(events) { event ->
                    EventCard(event)
                }
            }
        }
    }
}

@Composable
fun EventCard(event: ScoutEventResponse) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                val type = event.eventType ?: "INFO"
                Text(
                    text = type,
                    style = MaterialTheme.typography.labelLarge,
                    color = when(type) {
                        "PERFORMANCE" -> Color(0xFF4CAF50)
                        "TRANSFER" -> Color(0xFF2196F3)
                        "INJURY" -> Color(0xFFF44336)
                        else -> MaterialTheme.colorScheme.primary
                    }
                )
                Text(text = event.createdAt ?: "", style = MaterialTheme.typography.labelSmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.player?.name ?: "Giocatore sconosciuto", 
                style = MaterialTheme.typography.titleMedium, 
                fontWeight = FontWeight.Bold
            )
            Text(text = event.description ?: "Nessuna descrizione disponibile", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
