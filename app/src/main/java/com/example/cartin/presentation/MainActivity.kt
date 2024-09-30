package com.example.cartin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cartin.presentation.authentication.forgot_password.ForgotPasswordScreen
import com.example.cartin.presentation.authentication.login.LogInScreen
import com.example.cartin.presentation.authentication.sign_up.SignUpScreen
import com.example.cartin.presentation.bottom_nav.BottomNavigationScreen
import com.example.cartin.presentation.ui.theme.CartInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartInTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.SignUp.rout
                    ) {
                        composable(route = Screen.SignUp.rout) {
                            SignUpScreen(navController)
                        }
                        composable(Screen.LogIn.rout) {
                            LogInScreen(navController)
                        }
                        composable(Screen.ForgotPassword.rout) {
                            ForgotPasswordScreen(navController)
                        }
                        composable(Screen.homeScreen.rout) {
                            ForgotPasswordScreen(navController)
                        }
                        composable(Screen.bottomNavifgationScreen.rout) {
                            BottomNavigationScreen()
                        }

                    }
                }

            }
        }
    }
}
