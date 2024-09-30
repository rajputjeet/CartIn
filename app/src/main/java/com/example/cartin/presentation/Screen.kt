package com.example.cartin.presentation

sealed class Screen(val rout: String) {

    object SignUp : Screen("sign_up")

    object LogIn : Screen("log_in")

    object ForgotPassword : Screen("forgot_password")

    object bottomNavifgationScreen : Screen("bottom_nav")

    object homeScreen : Screen("home")

    object shopScreen : Screen("shop")

    object bagScreen : Screen("bag")

    object favoriteScreen : Screen("fav")

    object profileScreen : Screen("profile")

    object womenShopScreen : Screen("women_shop")

    object menShopScreen : Screen("men_shop")

    object kidsShopScreen : Screen("kids_shop")


}