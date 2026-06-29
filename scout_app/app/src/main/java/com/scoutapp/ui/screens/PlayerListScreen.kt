package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.ui.components.PlayerCard
import com.scoutapp.utils.formatMarketValue

@Composable
fun PlayerListScreen(
    title: String,
    players: List<PlayerResponse>,
    isLoading: Boolean,
    error: String? = null,
    isGem: Boolean = false,
    onPlayerClick: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (error != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = error, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge)
            }
        } else if (players.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Nessun giocatore trovato", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn {
                items(players) { player ->
                    PlayerCard(
                        name = player.name ?: "N/A",
                        club = player.club ?: "N/A",
                        score = (if (isGem) player.hiddenGemScore else player.talentScore) ?: 0.0,
                        age = player.age,
                        marketValue = player.marketValueDisplay ?: formatMarketValue(player.marketValue),
                        photoUrl = player.photoUrl,
                        isGem = isGem,
                        isTalent = !isGem && player.talentScore != null && player.talentScore!! > 0,
                        onClick = { 
                            val navId = if (player.tmId != null && player.tmId != "0" && player.tmId != "") player.tmId else player.id.toString()
                            onPlayerClick(navId)
                        }
                    )
                }
            }
        }
    }
}
