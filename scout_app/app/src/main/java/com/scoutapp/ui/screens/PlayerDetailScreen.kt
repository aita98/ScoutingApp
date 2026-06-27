package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.geometry.Offset
import com.scoutapp.data.api.RadarResponse
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

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun PlayerDetailScreen(
    playerId: String,
    viewModel: PlayerDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(playerId) {
        if (playerId.isNotEmpty() && playerId != "null") {
            viewModel.loadPlayer(playerId)
        }
    }

    when (val currentState = state) {
        is PlayerDetailState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is PlayerDetailState.Success -> {
            val player = currentState.player
            val isWatchlisted = currentState.isWatchlisted
            val transfers = currentState.tmTransfers
            val injuries = currentState.tmInjuries
            val achievements = currentState.tmAchievements
            val marketHistory = currentState.tmMarketValueHistory
            val detailedStats = currentState.tmDetailedStats
            val fbrefStats = currentState.fbrefStats
            val foot = currentState.foot
            val shirtNumber = currentState.shirtNumber
            val citizenship = currentState.citizenship
            val contractExpires = currentState.contractExpires
            val birthDate = currentState.birthDate
            val enrichedData = currentState.enrichedData
            val recentMatches = currentState.recentMatches ?: emptyList()
            
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
                    fontWeight = FontWeight.Bold,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                
                // User Rating
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Il mio voto: ", style = MaterialTheme.typography.bodySmall)
                    Slider(
                        value = enrichedData?.userRating ?: 0f,
                        onValueChange = { 
                            val id = player.transfermarktId ?: player.tmId ?: player.id.toString()
                            viewModel.ratePlayer(id, it) 
                        },
                        valueRange = 0f..10f,
                        steps = 9,
                        modifier = Modifier.width(150.dp)
                    )
                    Text(
                        text = String.format(java.util.Locale.US, "%.1f", enrichedData?.userRating ?: 0f),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Text(
                    text = "${player.club ?: "N/A"} | ${player.position ?: "N/A"}${if (player.isRetired == true) " (Ritirato)" else ""}",
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

                Spacer(modifier = Modifier.height(12.dp))

                // Detailed Info Row
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        InfoColumn("Foot", foot ?: "N/A")
                        InfoColumn("Number", shirtNumber ?: "N/A")
                        val year = birthDate?.split("/")?.getOrNull(2) ?: "N/A"
                        InfoColumn("Born", year)
                        InfoColumn("Expires", contractExpires ?: "N/A")
                    }
                }

                if (citizenship.isNotEmpty()) {
                    Text(
                        text = citizenship.joinToString(" | "),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(top = 8.dp),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // FBREF Advanced Analytics Section
                if (fbrefStats != null) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Stats",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            
                            // Grid-like layout for stats
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    StatTextItem("Stagione", fbrefStats.season)
                                    StatTextItem("Partite", fbrefStats.matches.toString())
                                    StatTextItem("Minuti", "${fbrefStats.minutes}'")
                                }
                                
                                if (player.position?.contains("Portiere", ignoreCase = true) == true || 
                                    player.position?.contains("Goalkeeper", ignoreCase = true) == true ||
                                    player.position?.contains("GK", ignoreCase = true) == true) {
                                    // Goalkeeper layout
                                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        StatTextItem("Subiti", (player.goalsConceded ?: fbrefStats.goalsConceded).toString())
                                        StatTextItem("Clean Sheets", (player.cleanSheets ?: fbrefStats.cleanSheets).toString())
                                        StatTextItem("Valore", formatAnyMarketValue(player.marketValueDisplay ?: fbrefStats.marketValue))
                                    }
                                } else {
                                    // Outfield layout
                                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        StatTextItem("Gol", (player.goals ?: fbrefStats.goals).toString())
                                        StatTextItem("Assist", (player.assists ?: fbrefStats.assists).toString())
                                        StatTextItem("xG", String.format(java.util.Locale.US, "%.1f", player.xG ?: fbrefStats.xG))
                                    }
                                }

                                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    StatTextItem("Key Passes", fbrefStats.keyPasses.toString())
                                    StatTextItem("Prog. Passes", fbrefStats.progressivePasses.toString())
                                    StatTextItem("Prog. Carries", fbrefStats.progressiveCarries.toString())
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

                if (fbrefStats != null) {
                    // ... (keep existing stats card)
                }

                // Recent Form (Last 10 Matches)
                if (recentMatches.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Recent Form",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            FormChart(
                                matches = recentMatches,
                                modifier = Modifier.fillMaxWidth().height(120.dp)
                            )
                        }
                    }
                }

                // Season Stats (Old Transfermarkt simple stats)
                val seasonStats = player.statistics?.firstOrNull()
                
                if (seasonStats != null && fbrefStats == null) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Seasonal Stats",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                                StatItem("Apps", (seasonStats.appearances ?: 0).toString())
                                StatItem("Goals", (seasonStats.goals ?: 0).toString())
                                StatItem("Assists", (seasonStats.assists ?: 0).toString())
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                                StatItem("Mins", (seasonStats.minutesPlayed ?: 0).toString())
                                StatItem("Yellow", (seasonStats.yellowCards ?: 0).toString())
                                StatItem("Red", (seasonStats.redCards ?: 0).toString())
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

                // Technical Profile (Radar)
                state.let { s ->
                    val r = if (s is PlayerDetailState.Success) s.radar else null
                    if (r != null) {
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
                                
                                    val labelsList = listOf("Pace", "Shooting", "Passing", "Dribbling", "Physical", "Intelligence")
                                    val valuesList = listOf(
                                        (r.pace ?: 0).toFloat(), 
                                        (r.shooting ?: 0).toFloat(), 
                                        (r.passing ?: 0).toFloat(), 
                                        (r.dribbling ?: 0).toFloat(), 
                                        (r.physical ?: 0).toFloat(), 
                                        (r.intelligence ?: 0).toFloat()
                                    )
                                    
                                    if (valuesList.size == labelsList.size) {
                                        RadarChart(
                                            data = RadarData(
                                                labels = labelsList,
                                                values = valuesList
                                            ),
                                            modifier = Modifier
                                                .size(300.dp)
                                                .align(androidx.compose.ui.Alignment.CenterHorizontally)
                                        )
                                    }
                            }
                        }
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
                }

                // Career sections
                if (transfers.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    SectionTitle("Transfer History")
                    transfers.forEach { transfer ->
                        TransferItem(transfer)
                    }
                }

                if (injuries.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    SectionTitle("Injury History")
                    injuries.forEach { injury ->
                        InjuryItem(injury)
                    }
                }

                if (achievements.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    SectionTitle("Trophies & Achievements")
                    achievements.forEach { achievement ->
                        AchievementItem(achievement)
                    }
                }

                if (marketHistory.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    SectionTitle("Market Value History")
                    MarketValueChart(
                        history = marketHistory,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                if (detailedStats.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    SectionTitle("Career Stats Breakdown")
                    detailedStats.forEach { stat ->
                        DetailedStatItem(stat)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                OutlinedButton(
                    onClick = { viewModel.loadPlayer(playerId, forceRefresh = true) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("AGGIORNA DATI (API)")
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
        is PlayerDetailState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Qualcosa è andato storto",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = currentState.message,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = { viewModel.loadPlayer(playerId) }) {
                        Text("Riprova")
                    }
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp),
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun AchievementItem(achievement: com.scoutapp.data.model.TransfermarktAchievement) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = achievement.title ?: "N/A", fontWeight = FontWeight.Bold)
            val details = achievement.details?.firstOrNull()
            val season = when (val s = details?.season) {
                is String -> s
                is Map<*, *> -> s["name"] as? String ?: s["id"] as? String
                else -> null
            }
            if (season != null) {
                Text(text = "Season: $season", style = MaterialTheme.typography.bodySmall)
            }
            if ((achievement.count ?: 0) > 1) {
                Text(text = "Won ${achievement.count} times", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Composable
fun TransferItem(transfer: com.scoutapp.data.model.TransfermarktTransfer) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "${transfer.from?.name ?: "Unknown"} -> ${transfer.to?.name ?: "Unknown"}", fontWeight = FontWeight.Bold)
                Text(text = "Season: ${transfer.season ?: "N/A"} | Date: ${transfer.date ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
            }
            
            val displayFee = formatAnyMarketValue(transfer.fee)
            Text(text = displayFee, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun InjuryItem(injury: com.scoutapp.data.model.TransfermarktInjury) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.2f))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = injury.injury ?: "N/A", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.error)
            Text(text = "Period: ${injury.from ?: "?"} to ${injury.until ?: "?"} (${injury.days ?: "?"} days)", style = MaterialTheme.typography.bodySmall)
            Text(text = "Games missed: ${injury.gamesMissed ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
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

@Composable
fun InfoColumn(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
        Text(text = value, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MarketValueChart(
    history: List<com.scoutapp.data.model.TransfermarktMarketValuePoint>,
    modifier: Modifier = Modifier
) {
    // Sort oldest to newest (ascending chronological order)
    val points = history.sortedBy { 
        val parts = it.date?.split("/") ?: listOf("0", "0", "0")
        if (parts.size == 3) "${parts[2]}${parts[1]}${parts[0]}" else "0"
    }
    
    val values = points.map { point ->
        val rawValue = point.marketValue ?: "0"
        val cleanStr = rawValue.toString().replace("€", "").trim().lowercase()
        
        val hasM = cleanStr.contains("m")
        val hasK = cleanStr.contains("k")
        
        // Normalizzazione stringa numerica (gestione virgole e punti)
        var normalizedStr = cleanStr.replace("m", "").replace("k", "").replace(" ", "")
        if (normalizedStr.contains(",") && !normalizedStr.contains(".")) {
            normalizedStr = normalizedStr.replace(",", ".")
        }
        
        val numericPart = normalizedStr.replace(Regex("[^0-9.]"), "")
        val d = numericPart.toDoubleOrNull() ?: 0.0
        
        val absoluteValue = when {
            hasM -> if (d > 1000) d else d * 1_000_000.0
            hasK -> if (d > 1000000) d else d * 1_000.0
            else -> if (d > 0 && d < 1000) d * 1_000_000.0 else d
        }
        absoluteValue / 1_000_000.0
    }
    
    val labels = points.map { it.date?.split("/")?.lastOrNull() ?: "" }
    
    if (values.isEmpty()) return

    val maxValue = (values.maxOrNull()?.takeIf { it > 0 } ?: 1.0).toFloat()
    val primaryColor = MaterialTheme.colorScheme.primary

    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val spacing = if (values.size > 1) width / (values.size - 1) else width
        
        // Draw Y-axis labels
        val paint = android.graphics.Paint().apply {
            color = android.graphics.Color.WHITE
            textSize = 24f
            isAntiAlias = true
        }
        
        val steps = 4
        for (i in 0..steps) {
            val yValue = maxValue * (i.toFloat() / steps)
            val yPos = height - (yValue / maxValue * height)
            
            // Format labels as Millions (e.g. 120.0M)
            val label = String.format(java.util.Locale.US, "%.1fM", yValue)
            
            drawContext.canvas.nativeCanvas.drawText(
                label,
                -10f, 
                yPos + 8f, // Center text vertically on the line
                paint
            )
            
            drawLine(
                color = Color.Gray.copy(alpha = 0.15f),
                start = Offset(0f, yPos),
                end = Offset(width, yPos),
                strokeWidth = 1.dp.toPx()
            )
        }

        val path = Path()
        values.forEachIndexed { index, value ->
            val x = index * spacing
            val y = height - (value.toFloat() / maxValue * height)
            if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
            
            // Draw points
            drawCircle(color = primaryColor, radius = 3.5.dp.toPx(), center = Offset(x, y))
            
            // Draw Year Label
            if (index == 0 || index == values.size - 1 || index % (values.size / 5).coerceAtLeast(1) == 0) {
                drawContext.canvas.nativeCanvas.drawText(
                    labels[index],
                    x,
                    height + 25.dp.toPx(),
                    android.graphics.Paint().apply {
                        color = android.graphics.Color.GRAY
                        textSize = 22f
                        textAlign = android.graphics.Paint.Align.CENTER
                    }
                )
            }
        }
        drawPath(path = path, color = primaryColor, style = Stroke(width = 2.5.dp.toPx()))
    }
}

@Composable
fun FbrefStatsCard(stats: com.scoutapp.domain.model.PlayerStats) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Season ${stats.season}", style = MaterialTheme.typography.titleMedium)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Attacking
            Text("Attacking & Creative", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.secondary)
            Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), Arrangement.SpaceEvenly) {
                StatMiniItem("xG", String.format(java.util.Locale.getDefault(), "%.2f", stats.xG))
                StatMiniItem("xA", String.format(java.util.Locale.getDefault(), "%.2f", stats.xA))
                StatMiniItem("Goals", "${stats.goals}")
            }
            
            Divider(Modifier.padding(vertical = 8.dp), thickness = 0.5.dp)
            
            // Progression
            Text("Progression", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.secondary)
            Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), Arrangement.SpaceEvenly) {
                StatMiniItem("Prog. Pass", "${stats.progressivePasses}")
                StatMiniItem("Prog. Carry", "${stats.progressiveCarries}")
                StatMiniItem("Key Passes", "${stats.keyPasses}")
            }
        }
    }
}

@Composable
fun DetailedStatItem(stat: com.scoutapp.data.model.TransfermarktDetailedStat) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Season: ${stat.seasonId ?: "N/A"}", fontWeight = FontWeight.Bold)
                Text(text = stat.competitionName?.toString() ?: "N/A", style = MaterialTheme.typography.labelSmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                StatMiniItem("Apps", stat.appearances?.toString())
                StatMiniItem("Goals", stat.goals?.toString())
                StatMiniItem("Assists", stat.assists?.toString())
                StatMiniItem("Mins", stat.minutesPlayed?.toString())
            }
        }
    }
}

@Composable
fun StatMiniItem(label: String, value: String?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value ?: "0", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f))
    }
}

@Composable
fun StatTextItem(label: String, value: String) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f))
        Text(text = value, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
    }
}

fun formatMarketValue(value: Double?): String {
    if (value == null || value == 0.0) return "N/A"
    // Se il valore è molto piccolo (es. < 1000), è quasi certamente già in scala milioni (es. 120.0 invece di 120.000.000)
    val normalized = if (value > 0 && value < 1000) value * 1_000_000.0 else value
    
    return if (normalized >= 1_000_000) {
        String.format(java.util.Locale.US, "%.1fM€", normalized / 1_000_000.0)
    } else if (normalized >= 1_000) {
        String.format(java.util.Locale.US, "%.0fK€", normalized / 1_000.0)
    } else {
        String.format(java.util.Locale.US, "%.0f€", normalized)
    }
}

/**
 * Universal formatter for any market value type (String, Number, etc.)
 * Handles scientific notation, suffixes, and raw large numbers.
 */
fun formatAnyMarketValue(value: Any?): String {
    if (value == null) return "N/A"
    
    val rawString = value.toString().trim()
    if (rawString.isEmpty() || rawString.lowercase() == "n/a" || rawString == "0") return "N/A"
    
    val cleanStr = rawString.replace("€", "").lowercase()
    val hasM = cleanStr.contains("m")
    val hasK = cleanStr.contains("k")
    
    val numericPart = cleanStr.replace("m", "").replace("k", "").replace(" ", "")
        .replace(Regex("[^0-9.eE\\-]"), "")
    
    val d = numericPart.toDoubleOrNull() ?: return rawString
    
    // Normalizziamo in valore assoluto (Euro)
    val absoluteValue = when {
        hasM -> if (d > 1000) d else d * 1_000_000.0
        hasK -> if (d > 1000000) d else d * 1_000.0
        else -> if (d > 0 && d < 1000) d * 1_000_000.0 else d
    }
    
    return if (absoluteValue >= 1_000_000) {
        String.format(java.util.Locale.US, "%.1fM€", absoluteValue / 1_000_000.0)
    } else if (absoluteValue >= 1_000) {
        String.format(java.util.Locale.US, "%.0fK€", absoluteValue / 1_000.0)
    } else {
        String.format(java.util.Locale.US, "%.0f€", absoluteValue)
    }
}

@Composable
fun FormChart(
    matches: List<com.scoutapp.data.api.RecentMatch>,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val neutralColor = Color.Gray.copy(alpha = 0.3f)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        matches.take(10).forEach { match ->
            val score = calculateMatchScore(match)
            val barHeight = (score * 10).coerceAtLeast(10f) // Scale 0-10 to 0-100dp
            
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .height(barHeight.dp)
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                        .background(
                            if (match.goals != null && match.goals > 0) primaryColor 
                            else if (match.assists != null && match.assists > 0) secondaryColor
                            else neutralColor
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                val label = if ((match.goals ?: 0) > 0) "G" else if ((match.assists ?: 0) > 0) "A" else ""
                Text(label, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

private fun calculateMatchScore(match: com.scoutapp.data.api.RecentMatch): Float {
    var score = 5f // Base for appearing
    if (match.isStarting == true) score += 1f
    score += (match.goals ?: 0) * 3f
    score += (match.assists ?: 0) * 1.5f
    val mins = match.minutes ?: 0
    score += mins / 45f
    return score.coerceIn(0f, 10f)
}
