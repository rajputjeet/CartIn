package com.example.cartin.presentation.bottom_nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cartin.R
import com.example.cartin.presentation.Screen
import com.example.cartin.presentation.bottom_nav.items.BottomNavigationItem
import com.example.cartin.presentation.categories.WomenCategories
import com.example.cartin.presentation.categories.kids_categories_screen.KidsCategories
import com.example.cartin.presentation.categories.men_catefories_screen.MenCategories
import com.example.cartin.presentation.home.HomeScreen
import com.example.cartin.presentation.shop.ShopScreen
import com.example.cartin.presentation.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationScreen() {

    val bottomNavController = rememberNavController()

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            rout = Screen.homeScreen.rout,
            selectedIcon = painterResource(id = R.drawable.icon_home_selected),
            unSelectedIcon = painterResource(id = R.drawable.icon_home_unselected),
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Shop",
            rout = Screen.shopScreen.rout,
            selectedIcon = painterResource(id = R.drawable.icon_cart_selected),
            unSelectedIcon = painterResource(id = R.drawable.icon_cart_unselected),
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = "Bag",
            rout = Screen.bagScreen.rout,
            selectedIcon = painterResource(id = R.drawable.icon_bag_selected),
            unSelectedIcon = painterResource(id = R.drawable.icon_bag_unselected),
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = "Fav",
            rout = Screen.favoriteScreen.rout,
            selectedIcon = painterResource(id = R.drawable.icon_fav_selected),
            unSelectedIcon = painterResource(id = R.drawable.icon_fav_unselected),
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = "Profile",
            rout = Screen.profileScreen.rout,
            selectedIcon = painterResource(id = R.drawable.icon_profile_selected),
            unSelectedIcon = painterResource(id = R.drawable.icon_profile_unselected),
            hasNews = false,
            badgeCount = null
        )
    )

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->

                    NavigationBarItem(selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            bottomNavController.navigate(item.rout)
                        },
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    painter = if (index == selectedItem) {
                                        item.selectedIcon
                                    } else {
                                        item.unSelectedIcon
                                    }, contentDescription = null,
                                    tint = if (selectedItem == index) Orange else Color.Gray
                                )

                            }

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue,  // Color for the selected icon
                            unselectedIconColor = Color.Gray, // Color for the unselected icon
                            selectedTextColor = Orange,   // Color for the selected label
                            unselectedTextColor = Color.Gray, // Color for the unselected label
                            indicatorColor = Color.White // Highlight background color for the selected item
                        )
                    )

                }

            }
        }
    ) { paddingValues ->
        // Apply padding to your content
        // Apply padding to the NavHost using Modifier.padding(paddingValues)
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.homeScreen.rout,
            modifier = Modifier.padding(paddingValues)  // This ensures no overlap with the bottom bar
        ) {
            composable(Screen.homeScreen.rout) {
                HomeScreen(bottomNavController)
            }
            composable(Screen.shopScreen.rout) {
                ShopScreen(bottomNavController)
            }
            composable(Screen.bagScreen.rout) {
                // BagScreen(navController) // Uncomment when implemented
            }
            composable(Screen.favoriteScreen.rout) {
                // FavoriteScreen(navController) // Uncomment when implemented
            }
            composable(Screen.profileScreen.rout) {
                // ProfileScreen(navController) // Uncomment when implemented
            }
            composable(Screen.womenShopScreen.rout) {
                WomenCategories(bottomNavController) // Uncomment when implemented
            }
            composable(Screen.menShopScreen.rout) {
                 MenCategories(bottomNavController) // Uncomment when implemented
            }
            composable(Screen.kidsShopScreen.rout) {
                 KidsCategories(bottomNavController) // Uncomment when implemented(navController) // Uncomment when implemented
            }
        }
    }

}