package com.example.cartin.presentation.categories.men_catefories_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.cartin.domain.model.category.Categories
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.Orange
import com.example.cartin.presentation.ui.theme.White

@Composable
fun MenCategories(navController: NavController) {

    val categories = ArrayList<Categories>().apply {

        add(
            Categories(
                "New",
                "https://images.pexels.com/photos/842811/pexels-photo-842811.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Categories(
                "Clothes",
                "https://images.pexels.com/photos/1040945/pexels-photo-1040945.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Categories(
                "Shoes",
                "https://images.pexels.com/photos/718981/pexels-photo-718981.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Categories(
                "Accesories",
                "https://images.pexels.com/photos/380782/pexels-photo-380782.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))

            )
            {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Orange),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "SUMMER SALE",
                            fontFamily = Metropolis,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            color = White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            text = "Up to 50% off",
                            fontFamily = Metropolis,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            color = White,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))  // Spacer between header and list
                }


                items(categories) { category ->

                    Spacer(modifier = Modifier.height(8.dp))

                    Card( modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                        elevation = CardDefaults.elevatedCardElevation(1.dp)

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()

                        ) {

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                                    .background(White),
                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = category.name,
                                    fontFamily = Metropolis,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )

                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                                    .background(White),
                                contentAlignment = Alignment.Center
                            ) {

                                Image(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    painter = rememberAsyncImagePainter(category.icon),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,

                                    )

                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                }

            }


        }

    }


}