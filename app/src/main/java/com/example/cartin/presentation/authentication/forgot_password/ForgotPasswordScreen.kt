package com.example.cartin.presentation.authentication.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.Orange
import com.example.cartin.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.statusBarsPadding()) {

            Spacer(modifier = Modifier.height(20.dp))

            TopSectionLogin(navController = navController)

            Spacer(modifier = Modifier.height(70.dp))

            TextFields(navController = navController,
                modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ))

            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .clip(shape = RoundedCornerShape(25.dp)
                    ),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(
                    text = "SEND",
                    color = White,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                )
            }


        }

    }

}

@Composable
fun TopSectionLogin(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column(
        modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    ) {

        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(36.dp)
                .align(alignment = Alignment.Start)
                .clickable { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Forgot password",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = Metropolis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .offset(x = (10).dp)
        )

    }
}

@ExperimentalMaterial3Api
@Composable
fun TextFields(
    navController: NavController,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        var email by remember {
            mutableStateOf("")
        }
        
        Text(text = "Please, enter your email address." +
                " You will receive a link to create a new password via email.",
            fontFamily = Metropolis,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))
        
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(1.dp)
                .background(Color.Transparent),
            value = email,
            onValueChange = { email = it },
            textStyle = LocalTextStyle.current.copy(
                fontFamily = Metropolis,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
            label = {
                Text(
                    text = "Email",
                    color = Color.DarkGray,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                )
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White, // Set TextField background to white
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
            )

        )
        
    }

}