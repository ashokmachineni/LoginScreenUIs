package com.nassrou.loginscreenui.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nassrou.loginscreenui.R
import com.nassrou.loginscreenui.ui.navigation.Routes

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header {
                navController.popBackStack()
            }
            InfoFields()
            Text(
                text = "Need Help?",
                style = MaterialTheme.typography.h6,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.HelpScreen.route)
                }
            )
        }
    }
}

@Composable
fun Header(onIconClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .clickable {
                    onIconClick()
                }
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ICON",
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun InfoFields() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isEmailValid by remember {
        mutableStateOf(true)
    }
    var isPasswordValid by remember {
        mutableStateOf(true)
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    var alphaValue by remember {
        mutableStateOf(0f)
    }
    val errorMsgAlpha by animateFloatAsState(
        targetValue = alphaValue,
        tween(
            durationMillis = 500,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    val triangleShape = GenericShape { size, _ ->
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(size.width/2, size.height)
    }
    val iconTint = animateColorAsState(
        if (isPasswordVisible) MaterialTheme.colors.primary else Color.LightGray
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "SIGN IN",
            style = MaterialTheme.typography.h1,
            color = Color.Black,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .alpha(errorMsgAlpha)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Red),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Uh Oh, something's gone wrong. Please try again",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .alpha(errorMsgAlpha)
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Box(modifier = Modifier
                .size(18.dp)
                .clip(triangleShape)
                .background(Color.Red))
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    isEmailValid = true
                }
                if (isEmailValid && isPasswordValid) {
                    alphaValue = 0f
                }
            },
            label = {
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.body1,
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier.fillMaxWidth(0.85f),
            isError = !isEmailValid,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = MaterialTheme.colors.primary,
                unfocusedLabelColor = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                if (password.length >= 8) {
                    isPasswordValid = true
                }
                if (isEmailValid && isPasswordValid) {
                    alphaValue = 0f
                }
            },
            label = {
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.body1,
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier.fillMaxWidth(0.85f),
            isError = !isPasswordValid,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_eye),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    },
                    tint = iconTint.value
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = MaterialTheme.colors.primary,
                unfocusedLabelColor = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = {
                if (password.length < 8) {
                    isPasswordValid = false
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    isEmailValid = false
                }
                if (isPasswordValid && isEmailValid) {
                    alphaValue = 0f
                    //navigate to next screen
                } else {
                    alphaValue = 1f
                }
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(
                text = "SIGN IN",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}
