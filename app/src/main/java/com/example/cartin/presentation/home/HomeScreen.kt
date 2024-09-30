package com.example.cartin.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.cartin.R
import com.example.cartin.domain.model.Cloth
import com.example.cartin.presentation.ui.theme.Metropolis
import com.example.cartin.presentation.ui.theme.Orange
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@Composable
fun HomeScreen(
    navController: NavController,
) {
    Log.d("sdfgadrgh", "ARRIVED")
    val images = listOf(
        "https://cdn.pixabay.com/photo/2021/11/05/12/27/woman-6771288_1280.jpg",
        "https://images.pexels.com/photos/896293/pexels-photo-896293.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://images.pexels.com/photos/2235071/pexels-photo-2235071.jpeg",
    )

    val clothArrayList = arrayListOf<Cloth>().apply {
        add(
            Cloth(
                "Denim Jacket",
                "Jacket",
                "4.5",
                "$59.99",
                "20%",
                "https://images.pexels.com/photos/3538010/pexels-photo-3538010.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Cloth(
                "Graphic T-Shirt",
                "T-Shirt",
                "4.7",
                "$19.99",
                "10%",
                "https://images.pexels.com/photos/11288120/pexels-photo-11288120.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Cloth(
                "Chino Pants", "Pants", "4.3", "$39.99", "15%",
                "https://images.pexels.com/photos/28570315/pexels-photo-28570315/free-photo-of-young-woman-with-tablet-and-headphones.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Cloth(
                "Leather Jacket",
                "Jacket",
                "4.8",
                "$129.99",
                "25%",
                "https://images.pexels.com/photos/1452743/pexels-photo-1452743.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Cloth(
                "Evening Dress",
                "Dorothy Perkins",
                "4.6",
                "$89.99",
                "30%",
                "https://images.pexels.com/photos/20089859/pexels-photo-20089859/free-photo-of-woman-in-tight-black-evening-dress-walking-behind-curtain.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )

        add(
            Cloth(
                "Floral Dress",
                "Dress",
                "4.5",
                "$49.99",
                "20%",
                "https://images.pexels.com/photos/28496351/pexels-photo-28496351/free-photo-of-traditional-mexican-dress-and-charro-style.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
        add(
            Cloth(
                "Wool Sweater",
                "Sweater",
                "4.4",
                "$69.99",
                "10%",
                "https://images.pexels.com/photos/16850465/pexels-photo-16850465/free-photo-of-a-young-woman-in-a-beige-hat-and-white-jumper-sitting-beside-two-retro-tv-sets.jpeg?auto=compress&cs=tinysrgb&w=600"
            )
        )
    }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp // Screen height in dp


    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())

        ) {

            ImageSlider(
                images = images,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClothsList(
                cloths = clothArrayList,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(10.dp))


            ClothsList(
                cloths = clothArrayList,
                modifier = Modifier
            )
        }

    }

}

@Composable
fun ImageSlider(
    images: List<String>,
    modifier: Modifier = Modifier
) {
    Log.d("sdfgadrgh", "IMAGE_SLIDER")

    val pagerState = rememberPagerState(pageCount = { images.size })

    // Auto-scroll
    LaunchedEffect(pagerState) {
        while (true) {
            yield()
            delay(3000L)
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth(),
    ) { page ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(LocalConfiguration.current.screenHeightDp.dp * 0.8f)

        ) {

            Column {

                Image(
                    painter = rememberAsyncImagePainter(images[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )
                Log.d("SDFGSDEFG", "${images[page]}")

            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {

                Text(
                    text = "Fashion\n sale",
                    lineHeight = 40.sp,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    color = Color.White


                )

                Spacer(modifier = Modifier.height(5.dp))

                Button(
                    onClick = {
                    },
                    colors = ButtonDefaults.buttonColors(Orange)
                ) {
                    Text(
                        text = "Check",
                        color = Color.White,
                        fontFamily = Metropolis,
                        fontWeight = FontWeight.Normal
                    )
                }

            }
        }

    }

}

@Composable
fun ClothsList(cloths: List<Cloth>, modifier: Modifier) {

    Column(modifier = modifier.fillMaxWidth()) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Sale",
                fontFamily = Metropolis,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )

            Text(
                text = "View all",
                fontFamily = Metropolis,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(end = 16.dp)

            )
        }

        Text(
            text = "Super summer sale",
            fontFamily = Metropolis,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.LightGray,
            modifier = Modifier
                .padding(start = 16.dp)


        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(cloths) { cloth ->

                Column(
                    modifier = Modifier
                        .width(148.dp)
                        .padding(
                            start = 5.dp,
                            end = 5.dp
                        )
                ) {



                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(212.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                    ) {

                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(184.dp),
                            painter = rememberAsyncImagePainter(cloth.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,

                            )

                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .height(24.dp)
                                .width(40.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Red)
                        ) {

                            Text(
                                text = cloth.discount,
                                fontFamily = Metropolis,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 11.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .align(Alignment.Center)

                            )

                        }

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)) {

                            Box(modifier = Modifier
                                .height(14.dp)
                                .width(95.dp)
                                .align(BottomStart)
                            ) {
                                StarRatingBar(
                                    rating = cloth.ratings.toFloat()) {}
                            }


                            FloatingActionButton(
                                onClick = { /*TODO*/ },
                                containerColor = Color.White,
                                shape = CircleShape,
                                elevation = FloatingActionButtonDefaults.elevation(1.dp),
                                modifier = Modifier
                                    .align(BottomEnd)
                                    .height(36.dp)
                                    .width(36.dp)

                            ){
                                Icon(
                                    painter = painterResource(R.drawable.icon_heart),
                                    contentDescription = null,
                                    tint = Color.Gray,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }

                        }

                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = cloth.type,
                        fontFamily = Metropolis,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        color = Color.LightGray,
                        modifier = Modifier

                    )

                    Text(
                        text = cloth.name,
                        fontFamily = Metropolis,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier

                    )

                    Text(
                        text = cloth.price,
                        fontFamily = Metropolis,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier

                    )

                }

            }


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
