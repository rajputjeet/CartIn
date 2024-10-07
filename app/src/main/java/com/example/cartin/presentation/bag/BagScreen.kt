package com.example.cartin.presentation.bag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.cartin.R
import com.example.cartin.domain.model.BagItemModel
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.Orange
import com.example.cartin.presentation.ui.theme.White

@Composable
fun BagScreen(navController: NavController) {

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
                text = "My Bag",
                fontFamily = Metropolis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(16.dp))

            BagList(cloths = dummyBagItems)


        }

    }

}

@Composable
fun BagList(cloths: List<BagItemModel>, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            items(cloths) { cloth ->

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(104.dp),
                    elevation = CardDefaults.elevatedCardElevation(1.dp),
                    colors = CardDefaults.cardColors(containerColor = White)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    {

                        Image(
                            modifier = Modifier
                                .width(104.dp)
                                .fillMaxHeight(),
                            painter = rememberAsyncImagePainter(cloth.imageUrl),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,

                            )

                        Spacer(modifier = Modifier.width(8.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(
                                    top = 8.dp,
                                    bottom = 8.dp
                                )
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {

                                    Text(
                                        text = cloth.name,
                                        fontFamily = Metropolis,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 16.sp,
                                        color = Color.Black
                                    )

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

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 5.dp)
                                    ) {

                                        Box(
                                            modifier = Modifier
                                                .height(36.dp)
                                                .fillMaxWidth()
                                                .weight(1f)
                                        ) {

                                            Row(modifier = Modifier) {
                                                FloatingActionButton(modifier = Modifier
                                                    .height(36.dp)
                                                    .width(36.dp),
                                                    containerColor = Color.White,
                                                    shape = CircleShape,
                                                    elevation = FloatingActionButtonDefaults.elevation(
                                                        1.dp
                                                    ),
                                                    onClick = {}
                                                ) {

                                                    Icon(
                                                        painter = painterResource(id = R.drawable.icon_minus),
                                                        contentDescription = null,
                                                        tint = Color.LightGray
                                                    )

                                                }

                                                Text(
                                                    text = "1",
                                                    fontFamily = Metropolis,
                                                    fontWeight = FontWeight.Normal,
                                                    fontSize = 14.sp,
                                                    color = Color.Black,
                                                    modifier = Modifier
                                                        .padding(
                                                            start = 10.dp,
                                                            end = 10.dp
                                                        )
                                                        .align(Alignment.CenterVertically)

                                                )

                                                FloatingActionButton(modifier = Modifier
                                                    .height(36.dp)
                                                    .width(36.dp),
                                                    containerColor = Color.White,
                                                    shape = CircleShape,
                                                    elevation = FloatingActionButtonDefaults.elevation(
                                                        1.dp
                                                    ),
                                                    onClick = {}
                                                ) {

                                                    Icon(
                                                        imageVector = Icons.Default.Add,
                                                        contentDescription = null,
                                                        tint = Color.LightGray,
                                                        modifier = Modifier
                                                    )

                                                }

                                            }

                                        }

//                                    Spacer(modifier = Modifier.weight(1f))

                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.CenterVertically)
                                                .height(36.dp)
                                        ) {

                                            Text(
                                                text = "${cloth.price}$",
                                                fontFamily = Metropolis,
                                                fontWeight = FontWeight.Normal,
                                                fontSize = 14.sp,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier
                                                    .align(Alignment.Center)
                                            )
                                        }

                                    }

                                }

                            }

                        }

                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null,
                                tint = Color.LightGray
                            )
                        }

                    }

                }

                Spacer(modifier = Modifier.height(8.dp))

            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            var couponCode by remember {
                mutableStateOf("")
            }

            Spacer(modifier = Modifier.height(1.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                elevation = CardDefaults.elevatedCardElevation(1.dp),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(White)
                ) {

                    TextField(
                        value = couponCode,
                        onValueChange = { couponCode = it },
                        textStyle = LocalTextStyle.current.copy(
                            fontFamily = Metropolis,
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                        ),
                        modifier = Modifier
                            .weight(1f),
                        placeholder = {
                            Text(
                                text = "Enter Your Promo Coupon Code",
                                color = Color.DarkGray,
                                fontFamily = Metropolis,
                                fontWeight = FontWeight.Normal,
                                fontSize = 11.sp,
                            )
                        },

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Characters
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

                    FloatingActionButton(modifier = Modifier
                        .fillMaxHeight()
                        .width(46.dp)
                        .align(Alignment.CenterVertically),
                        containerColor = Color.Black,
                        shape = CircleShape,
                        elevation = FloatingActionButtonDefaults.elevation(
                            1.dp
                        ),
                        onClick = {}
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                        )


                    }

                }

            }


        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier
            .fillMaxWidth()) {

            Text(
                text = "Total Amount:",
                color = Color.LightGray,
                fontFamily = Metropolis,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = Modifier
                    .weight(1f)
            )

            Text(
                text =  cloths.sumOf { it.price.toInt() }.toString() + "$",
                color = Color.Black,
                fontFamily = Metropolis,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {},
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
                text = "CHECK OUT",
                color = White,
                fontFamily = Metropolis,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}