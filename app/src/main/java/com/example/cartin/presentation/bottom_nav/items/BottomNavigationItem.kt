package com.example.cartin.presentation.bottom_nav.items

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavigationItem(
    val title: String,
    val rout: String,
    val selectedIcon: Painter,
    val unSelectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount: Int? = null


)
