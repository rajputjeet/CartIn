package com.example.cartin.presentation.authentication.login

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cartin.R
import com.example.cartin.presentation.Screen
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.Orange
import com.example.cartin.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .statusBarsPadding()
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            TopSectionLogin(navController)

            Spacer(modifier = Modifier.height(70.dp))

            TextFields(
                navController = navController,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.bottomNavifgationScreen.rout)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .clip(
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(
                    text = "LOGIN",
                    color = White,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.height(90.dp))

            SocialLoginSection()

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
            text = "Login",
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

        var password by remember {
            mutableStateOf("")
        }


        Spacer(modifier = Modifier.height(16.dp))

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

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White, // Set TextField background to white
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
            )

        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(1.dp)
                .background(Color.Transparent),
            value = password,
            onValueChange = { password = it },
            textStyle = LocalTextStyle.current.copy(
                fontFamily = Metropolis,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
            label = {
                Text(
                    text = "Password",
                    color = Color.DarkGray,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                )
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
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

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                modifier = Modifier
                    .offset(y = (2).dp),
                text = "Forgot your password?",
                color = Color.Black,
                fontFamily = Metropolis,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )

            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clickable { navController.navigate(Screen.ForgotPassword.rout) }
                    .align(Alignment.CenterVertically),
                imageVector = Icons.Default.ArrowForward,
                tint = Orange,
                contentDescription = null,

                )

        }

    }

}

@Composable
fun SocialLoginSection(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            text = "Or login with social account",
            color = Color.Black,
            fontFamily = Metropolis,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)


        ) {

            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .height(80.dp)
                    .width(80.dp)
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(1.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = MaterialTheme.shapes.extraLarge
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize() // Fill the card
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp) // Adjust image size if needed
                    )
                }
            }

            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .height(80.dp)
                    .width(80.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(1.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = MaterialTheme.shapes.extraLarge
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize() // Fill the card
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp) // Adjust image size if needed
                    )
                }

            }

        }

    }

}