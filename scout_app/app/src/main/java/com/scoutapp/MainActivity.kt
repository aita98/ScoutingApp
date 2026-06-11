package com.scoutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.scoutapp.ui.components.BottomNavigationBar
import com.scoutapp.ui.components.Screen
import com.scoutapp.ui.theme.ScoutTheme
import androidx.hilt.navigation.compose.hiltViewModel
import com.scoutapp.viewmodel.ScoutingViewModel
import com.scoutapp.ui.screens.*
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.unit.dp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScoutTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val scoutingViewModel: ScoutingViewModel = hiltViewModel()
                val isOffline by scoutingViewModel.isOffline.collectAsState()
                val error by scoutingViewModel.error.collectAsState()

                LaunchedEffect(Unit) {
                    scoutingViewModel.loadAllData()
                }

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(currentRoute) { route ->
                            navController.navigate(route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    },
                    topBar = {
                        Column {
                            if (isOffline) {
                                Surface(
                                    color = MaterialTheme.colorScheme.errorContainer,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Connessione assente. Modalità Offline attiva.",
                                        modifier = Modifier.padding(8.dp),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onErrorContainer,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                    )
                                }
                            } else if (error != null) {
                                Surface(
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = error!!,
                                        modifier = Modifier.padding(8.dp),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Consigliati.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Monitorati.route) { 
                            val players by scoutingViewModel.watchlist.collectAsState()
                            val loading by scoutingViewModel.isLoading.collectAsState()
                            val error by scoutingViewModel.error.collectAsState()
                            PlayerListScreen("Watchlist", players, loading, error) { id ->
                                navController.navigate("player_detail/$id")
                            }
                        }
                        
                        composable(Screen.Consigliati.route) { 
                            val players by scoutingViewModel.recommended.collectAsState()
                            val loading by scoutingViewModel.isLoading.collectAsState()
                            val error by scoutingViewModel.error.collectAsState()
                            PlayerListScreen("Top Prospects", players, loading, error) { id ->
                                navController.navigate("player_detail/$id")
                            }
                        }
                        
                        composable(Screen.HiddenGems.route) { 
                            val players by scoutingViewModel.hiddenGems.collectAsState()
                            val loading by scoutingViewModel.isLoading.collectAsState()
                            val error by scoutingViewModel.error.collectAsState()
                            PlayerListScreen("Hidden Gems", players, loading, error, isGem = true) { id ->
                                navController.navigate("player_detail/$id")
                            }
                        }

                        composable(Screen.Leagues.route) {
                            LeaguesScreen(onLeagueClick = { id ->
                                navController.navigate("league_teams/$id")
                            })
                        }

                        composable("league_teams/{leagueId}") { backStackEntry ->
                            val leagueId = backStackEntry.arguments?.getString("leagueId")
                            if (leagueId != null) {
                                LeagueTeamsScreen(leagueId, onTeamClick = { id ->
                                    navController.navigate("team_detail/$id")
                                })
                            }
                        }

                        composable("team_detail/{teamId}") { backStackEntry ->
                            val teamId = backStackEntry.arguments?.getString("teamId")
                            if (teamId != null) {
                                TeamDetailScreen(teamId, onPlayerClick = { id ->
                                    navController.navigate("player_detail/$id")
                                })
                            }
                        }

                        composable(Screen.ScoutFeed.route) { 
                            val events by scoutingViewModel.scoutFeed.collectAsState()
                            ScoutFeedScreen(events, onRefresh = { scoutingViewModel.triggerSync() })
                        }

                        composable(Screen.AIScout.route) { 
                            AIScoutScreen(onPlayerClick = { id ->
                                navController.navigate("player_detail/$id")
                            }) 
                        }

                        composable("compare") { ComparisonScreen() }
                        
                        composable("player_detail/{playerId}") { backStackEntry ->
                            val playerId = backStackEntry.arguments?.getString("playerId")
                            if (playerId != null) {
                                PlayerDetailScreen(playerId)
                            }
                        }

                        composable(Screen.Backend.route) {
                            BackendScreen(scoutingViewModel)
                        }
                    }
                }
            }
        }
    }
}
