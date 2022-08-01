package com.nassrou.loginscreenui.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nassrou.loginscreenui.ui.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { navController.navigate(Routes.LoginScreen.route) },
            modifier = Modifier.fillMaxWidth(0.65f),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "LOGIN",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}