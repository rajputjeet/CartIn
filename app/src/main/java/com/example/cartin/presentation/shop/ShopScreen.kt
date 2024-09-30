package com.example.cartin.presentation.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cartin.presentation.Screen
import com.example.cartin.presentation.categories.WomenCategories
import com.example.cartin.presentation.categories.kids_categories_screen.KidsCategories
import com.example.cartin.presentation.categories.men_catefories_screen.MenCategories
import com.example.cartin.presentation.shop.tab_item.TabItem
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.Orange
import kotlinx.coroutines.launch

@Composable
fun ShopScreen(navController: NavController) {

    val tabItems = listOf(
        TabItem("Women", Screen.womenShopScreen.rout),
        TabItem("Men", Screen.menShopScreen.rout),
        TabItem("Kids", Screen.kidsShopScreen.rout)
    )


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        var selectedTab by remember {
            mutableStateOf(0)
        }

        val pagerState = rememberPagerState {
            tabItems.size
        }

        LaunchedEffect(selectedTab) {

            pagerState.animateScrollToPage(selectedTab)

        }

    /*    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {

            if (!pagerState.isScrollInProgress) {
//
                selectedTab = pagerState.currentPage

            }

        }*/

        val scope = rememberCoroutineScope()
        LaunchedEffect(pagerState.currentPage) {
            selectedTab = pagerState.currentPage
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "Categories",
                    fontSize = 18.sp,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(CenterVertically)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(CenterVertically)


                )

            }

            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                        color = Orange,
                    )

                },
            ) {
                tabItems.forEachIndexed() { index, item ->

                    Tab(
                        selected = index == selectedTab,

                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                            selectedTab = index
                        },
                        text = {
                            Text(
                                text = item.title,
                                fontFamily = Metropolis,
                                fontWeight = if (index == selectedTab) FontWeight.SemiBold else FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.Black

                            )

                        }
                    )
                }

            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { index ->

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {

                    when (tabItems[index].route) {
                        Screen.menShopScreen.rout -> {
                            MenCategories(navController = navController)

                        }

                        Screen.kidsShopScreen.rout -> {
                            KidsCategories(navController = navController)

                        }

                        else -> {
                            WomenCategories(navController = navController)
                        }

                    }
                }

            }

        }

    }

}