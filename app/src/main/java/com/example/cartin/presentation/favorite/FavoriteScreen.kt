package com.example.cartin.presentation.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.cartin.R
import com.example.cartin.domain.model.BagItemModel
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.White

@Composable
fun FavoriteScreen(navController: NavController) {

    val dummyBagItems = listOf(
        BagItemModel(
            name = "T-shirt",
            price = 19.99,
            imageUrl = "https://images.pexels.com/photos/17243499/pexels-photo-17243499/free-photo-of-a-woman-leaning-against-a-wall-wearing-a-crop-top.jpeg?auto=compress&cs=tinysrgb&w=600",
            quantity = 1,
            color = "White",
            size = "M",
            ratings = 4.5,
            type = "T-shirt"
        ),
        BagItemModel(
            name = "Jeans",
            price = 49.99,
            imageUrl = "https://images.pexels.com/photos/17893854/pexels-photo-17893854/free-photo-of-blonde-woman-on-brown-background.jpeg?auto=compress&cs=tinysrgb&w=600",
            quantity = 2,
            color = "Black",
            size = "M",
            ratings = 4.0,
            type = "Jeans"
        ),
        BagItemModel(
            name = "Sneakers",
            price = 79.99,
            imageUrl = "https://images.pexels.com/photos/1054787/pexels-photo-1054787.jpeg?auto=compress&cs=tinysrgb&w=600",
            quantity = 1,
            color = "White",
            size = "10",
            ratings = 4.0,
            type = "Sneakers"
        ),
        BagItemModel(
            name = "Jacket",
            price = 99.99,
            imageUrl = "https://images.pexels.com/photos/19399678/pexels-photo-19399678/free-photo-of-young-woman-in-an-elegant-autumnal-outfit-posing-outside.jpeg?auto=compress&cs=tinysrgb&w=600",
            quantity = 1,
            color = "Brown",
            size = "L",
            ratings = 4.0,
            type = "Jacket"
        )
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Favorites",
                fontFamily = Metropolis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(16.dp))

            ClothsList(cloths = dummyBagItems, modifier = Modifier)

        }

    }

}

@Composable
fun ClothsList(cloths: List<BagItemModel>, modifier: Modifier) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(cloths) { cloth ->

            Spacer(modifier = Modifier.height(8.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(104.dp),
                elevation = CardDefaults.elevatedCardElevation(1.dp),
                colors = CardDefaults.cardColors(containerColor = White)
            ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(104.dp)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                        ) {

                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(184.dp),
                                painter = rememberAsyncImagePainter(cloth.imageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,

                                )

                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = cloth.type,
                                fontFamily = Metropolis,
                                fontWeight = FontWeight.Normal,
                                fontSize = 11.sp,
                                color = Color.LightGray,
                                modifier = Modifier

                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = cloth.name,
                                fontFamily = Metropolis,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier

                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(modifier = Modifier) {

                                Text(
                                    text = "Color:",
                                    fontFamily = Metropolis,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 11.sp,
                                    color = Color.LightGray
                                )

                                Text(
                                    text = cloth.color,
                                    fontFamily = Metropolis,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 11.sp,
                                    color = Color.Black
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                Text(
                                    text = "Size:",
                                    fontFamily = Metropolis,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 11.sp,
                                    color = Color.LightGray
                                )

                                Text(
                                    text = cloth.size,
                                    fontFamily = Metropolis,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 11.sp,
                                    color = Color.Black
                                )

                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {


                                Text(
                                    text = cloth.price.toString() + "$",
                                    fontFamily = Metropolis,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    modifier = Modifier

                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                StarRatingBar(
                                    rating = cloth.ratings.toFloat()
                                ) {}
                            }


                            FloatingActionButton(
                                onClick = { /*TODO*/ },
                                containerColor = Color.White,
                                shape = CircleShape,
                                elevation = FloatingActionButtonDefaults.elevation(1.dp),
                                modifier = Modifier
                                    .height(36.dp)
                                    .width(36.dp)

                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.icon_heart),
                                    contentDescription = null,
                                    tint = Color.Gray,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }

                        }


                        Spacer(modifier = Modifier.height(5.dp))


                    }
                }

            Spacer(modifier = Modifier.height(8.dp))

            }

        }

    }


@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    rating: Float,
    onRatingChanged: (Float) -> Unit
) {
    val density = LocalDensity.current.density
    val starSize = (12f * density).dp
    val starSpacing = (0.1f * density).dp

    Row(
        modifier = Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val icon = if (isSelected) painterResource(id = R.drawable.icon_star_filled)
            else painterResource(id = R.drawable.icon_star_empty)
            val iconTintColor = if (isSelected) Color(0xFFFFC700) else Color(0x20FFFFFF)
            Icon(
                painter = icon,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .selectable(
                        selected = isSelected,
                        onClick = {
                            onRatingChanged(i.toFloat())
                        }
                    )
                    .width(starSize)
                    .height(starSize)
            )

            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}

