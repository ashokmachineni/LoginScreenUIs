package com.nassrou.loginscreenui.ui.navigation

sealed class Routes(val route: String) {
    object HomeScreen : Routes("home_screen")
    object LoginScreen : Routes("login_screen")
    object HelpScreen : Routes("help_screen")
}
