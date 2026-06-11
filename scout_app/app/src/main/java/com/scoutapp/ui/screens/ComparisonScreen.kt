package com.scoutapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.scoutapp.ui.components.RadarChart
import com.scoutapp.ui.components.RadarData

@Composable
fun ComparisonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Player Comparison",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            PlayerBrief("Lamine Yamal", "Barcelona", Modifier.weight(1f))
            Text("VS", modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 8.dp), fontWeight = FontWeight.Bold)
            PlayerBrief("Endrick", "Real Madrid", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Technical Overlay", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        
        Box(modifier = Modifier.fillMaxWidth().height(300.dp), contentAlignment = Alignment.Center) {
            // In a real implementation, we would draw two paths on the same radar
            RadarChart(
                data = RadarData(
                    labels = listOf("Pace", "Shooting", "Passing", "Dribbling", "Physical", "Intelligence"),
                    values = listOf(92f, 85f, 88f, 96f, 65f, 82f)
                ),
                color = Color.Green
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        ComparisonMetricRow("Goals / 90", "0.45", "0.52")
        ComparisonMetricRow("Assists / 90", "0.32", "0.15")
        ComparisonMetricRow("Minutes", "2150", "1840")
        ComparisonMetricRow("Talent Score", "94", "91")
    }
}

@Composable
fun PlayerBrief(name: String, club: String, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.size(64.dp).padding(8.dp), contentAlignment = Alignment.Center) {
            // Placeholder for photo
            Surface(modifier = Modifier.fillMaxSize(), shape = androidx.compose.foundation.shape.CircleShape, color = Color.Gray) {}
        }
        Text(name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
        Text(club, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}

@Composable
fun ComparisonMetricRow(label: String, valA: String, valB: String) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(label, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(valA, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = if(valA > valB) Color.Green else Color.White)
            Text(valB, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = if(valB > valA) Color.Green else Color.White)
        }
        LinearProgressIndicator(
            progress = 0.5f, // Simplified comparison bar
            modifier = Modifier.fillMaxWidth().height(4.dp).padding(top = 4.dp),
            color = Color.Green,
            trackColor = Color.Red
        )
    }
}
