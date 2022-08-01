package com.nassrou.loginscreenui.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HelpScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Need Help?",
            style = MaterialTheme.typography.h2,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Please Read Here",
            style = MaterialTheme.typography.h3,
            color = Color.Black,
            fontSize = 15.sp
        )
    }
}