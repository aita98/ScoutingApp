package com.scoutapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Monitorati : Screen("monitored", "Monitorati", Icons.Default.Visibility)
    object OTW : Screen("otw", "OTW", Icons.Default.Star)
    object HiddenGems : Screen("gems", "Hidden Gems", Icons.Default.Diamond)
    object ScoutFeed : Screen("feed", "Feed", Icons.Default.RssFeed)
    object AIScout : Screen("ai_scout", "AI Scout", Icons.Default.Psychology)
    object Leagues : Screen("leagues", "Campionati", Icons.Default.Public)
    object Backend : Screen("backend", "Backend", Icons.Default.Settings)
}

@Composable
fun BottomNavigationBar(currentRoute: String?, onNavigate: (String) -> Unit) {
    val items = listOf(
        Screen.Monitorati,
        Screen.OTW,
        Screen.HiddenGems,
        Screen.Leagues,
        Screen.ScoutFeed,
        Screen.AIScout,
        Screen.Backend
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = { onNavigate(screen.route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = androidx.compose.ui.graphics.Color.Gray,
                    unselectedTextColor = androidx.compose.ui.graphics.Color.Gray
                )
            )
        }
    }
}
