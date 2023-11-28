package com.example.bottomnavigationmenucompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bottomnavigationmenucompose.R

sealed class NavigationItem(var title: String, var icon: ImageVector, var route: String) {

    object Home : NavigationItem("Home", Icons.Default.Home, "home")
    object Info : NavigationItem("Info", Icons.Default.Info, "info")
    object Settings : NavigationItem("Settings", Icons.Default.Settings, "settings")

}
