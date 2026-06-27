import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sync
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

// --- DATA MODELS ---

data class Player(
    val id: Long,
    val name: String?,
    val position: String?,
    val age: Int?,
    val club: String?,
    val league: String?,
    val marketValueDisplay: String?,
    val transfermarktId: String?,
    val statistics: List<SeasonStats>?
)

data class SeasonStats(
    val appearances: Int?,
    val goals: Int?,
    val assists: Int?
)

// --- RETROFIT API ---

interface ScoutBackendApi {
    @GET("api/players/db")
    suspend fun getPlayersFromDb(@Query("query") query: String = ""): List<Player>

    @POST("api/system/startup")
    suspend fun triggerSync(@Query("season") season: String): Map<String, String>
}

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:8080/") // Cambia se il backend è su un altro IP
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ScoutBackendApi = retrofit.create(ScoutBackendApi::class.java)
}

// --- APP ENTRY POINT ---

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ScoutApp - Desktop Control Center",
        state = rememberWindowState(width = 1000.dp, height = 800.dp)
    ) {
        MaterialTheme(
            colors = lightColors(
                primary = Color(0xFF1E88E5),
                surface = Color.White,
                background = Color(0xFFF5F5F5)
            )
        ) {
            SavedPlayersDesktopScreen()
        }
    }
}

@Composable
fun SavedPlayersDesktopScreen() {
    val scope = rememberCoroutineScope()
    var players by remember { mutableStateOf<List<Player>>(emptyList()) }
    var filteredPlayers by remember { mutableStateOf<List<Player>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedSeason by remember { mutableStateOf("2025") }
    var statusMessage by remember { mutableStateOf("") }

    fun loadPlayers() {
        scope.launch {
            isLoading = true
            try {
                players = ApiClient.api.getPlayersFromDb()
                filteredPlayers = players
            } catch (e: Exception) {
                statusMessage = "Errore caricamento: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun triggerSync() {
        scope.launch {
            isLoading = true
            try {
                val response = ApiClient.api.triggerSync(selectedSeason)
                statusMessage = response["message"] ?: "Sync avviato"
                loadPlayers()
            } catch (e: Exception) {
                statusMessage = "Errore sync: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    LaunchedEffect(Unit) {
        loadPlayers()
    }

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        // Top Bar
        TopAppBar(
            title = { Text("Database Giocatori Salvati", fontWeight = FontWeight.Bold) },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 4.dp,
            actions = {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 16.dp)) {
                    Text("Stagione:", fontSize = 14.sp)
                    Spacer(Modifier.width(8.dp))
                    SeasonDropdown(selectedSeason) { selectedSeason = it }
                    Spacer(Modifier.width(16.dp))
                    Button(onClick = { triggerSync() }, enabled = !isLoading) {
                        Icon(Icons.Default.Sync, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Avvia Sync")
                    }
                }
            }
        )

        // Main Content
        Column(modifier = Modifier.padding(24.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                        filteredPlayers = players.filter { p ->
                            p.name?.contains(it, ignoreCase = true) == true ||
                            p.club?.contains(it, ignoreCase = true) == true ||
                            p.league?.contains(it, ignoreCase = true) == true
                        }
                    },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Cerca per nome, club o campionato...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White)
                )
                
                Spacer(Modifier.width(16.dp))
                
                if (statusMessage.isNotEmpty()) {
                    Text(statusMessage, color = MaterialTheme.colors.primary, fontSize = 14.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (isLoading && players.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(filteredPlayers) { player ->
                        DesktopPlayerCard(player)
                    }
                }
            }
        }
    }
}

@Composable
fun DesktopPlayerCard(player: Player) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = player.name ?: "N/A",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${player.position ?: "N/A"} • ${player.age ?: "?"} anni",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "${player.club ?: "N/A"} - ${player.league ?: "N/A"}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium
                )
            }

            // Stats Section
            Row(modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.SpaceAround) {
                val stats = player.statistics?.firstOrNull()
                DesktopStatItem("Presenze", stats?.appearances?.toString() ?: "0")
                DesktopStatItem("Gol", stats?.goals?.toString() ?: "0")
                DesktopStatItem("Assist", stats?.assists?.toString() ?: "0")
            }

            Spacer(Modifier.width(32.dp))

            Text(
                text = player.marketValueDisplay ?: "N/A",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DesktopStatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
fun SeasonDropdown(selected: String, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val seasons = listOf("2024", "2025")

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            seasons.forEach { season ->
                DropdownMenuItem(onClick = {
                    onSelect(season)
                    expanded = false
                }) {
                    Text(season)
                }
            }
        }
    }
}
