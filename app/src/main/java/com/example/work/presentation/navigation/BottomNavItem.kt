package com.example.work.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    data object Home : BottomNavItem(
        route = "home",
        icon = Icons.Default.Home,
        label = "Home"
    )
    
    data object Search : BottomNavItem(
        route = "search",
        icon = Icons.Default.Search,
        label = "Search"
    )
    
    data object Profile : BottomNavItem(
        route = "profile",
        icon = Icons.Default.Person,
        label = "Profile"
    )
    
    data object Settings : BottomNavItem(
        route = "settings",
        icon = Icons.Default.Settings,
        label = "Settings"
    )
}