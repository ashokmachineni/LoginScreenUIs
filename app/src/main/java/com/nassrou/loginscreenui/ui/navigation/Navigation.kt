package com.nassrou.loginscreenui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nassrou.loginscreenui.ui.screens.HelpScreen
import com.nassrou.loginscreenui.ui.screens.HomeScreen
import com.nassrou.loginscreenui.ui.screens.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
        composable(route = Routes.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Routes.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Routes.HelpScreen.route) {
            HelpScreen(navController = navController)
        }
    }
}