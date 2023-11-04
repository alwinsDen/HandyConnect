//package com.alwinsden.finalebuild.android.ui
package com.alwinsden.finalebuild.android

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alwinsden.finalebuild.android.ui.ImageData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

//features listing
@Composable
fun FeatureLising() {
    //all the listing resources
    val imageData = listOf(
        ImageData(
            R.drawable.fac1, "Car\n" +
                    "technician"
        ),
        ImageData(R.drawable.fac2, "Plumber"),
        ImageData(R.drawable.fac3, "Electrician"),
        ImageData(
            R.drawable.fac4, "Wood\n" +
                    "working"
        ),
        ImageData(
            R.drawable.fac5, "Glass &\n" +
                    "Ceramics"
        ),
        ImageData(
            R.drawable.fac6, "Water\n" +
                    "supplier"
        ),
        ImageData(
            R.drawable.fac7, "Appliance\n" +
                    "repair"
        ),
        ImageData(R.drawable.fac8, "See all"),
    )
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xFFFFFFFF))
                .border(
                    color = Color(0xFF878787),
                    width = .5.dp,
                    shape = RoundedCornerShape(10)
                )
                .padding(bottom = 5.dp)
        ) {
            Text(
                text = "Features",
                fontFamily = urbanistFont,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (inx in 0..3) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = imageData[inx].resoureId),
                            contentDescription = "",
                            modifier = Modifier.size(45.dp)
                        )
                        Text(
                            text = imageData[inx].label,
                            fontFamily = urbanistFont,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 17.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (inx in 4..7) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = imageData[inx].resoureId),
                            contentDescription = "",
                            modifier = Modifier.size(45.dp)
                        )
                        Text(
                            text = imageData[inx].label,
                            fontFamily = urbanistFont,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 17.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            //TODO: LazyGrid Code fails to run app.
//            LazyVerticalGrid(columns = GridCells.Fixed(4),
//                content = {
//                    items(imageData) {
//                        Image(painter = painterResource(id = it.resoureId), contentDescription = "")
//                    }
//                })
        }
    }
}

//referral options
@Composable
fun ReferralRewards() {
    val imageList = listOf(
        ImageData(R.drawable.test_smiley, "Refer the app"),
        ImageData(R.drawable.test_smiley, "Earn Rewards!"),
        ImageData(R.drawable.test_smiley, "Discover more?"),
    )
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (imgData in imageList) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30))
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Color(0xFF9DCB3C))
                            .border(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(30),
                                width = 0.dp
                            )
                            .padding(
                                horizontal = 15.dp,
                                vertical = 10.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            model = imgData.resoureId,
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                        Text(
                            text = imgData.label,
                            color = Color(0xFFFFFFFF),
                            fontFamily = urbanistFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuickAccess() {
    //image list
    val imageList = listOf(
        ImageData(
            R.drawable.quicka1, "Credits/\n" +
                    "cards"
        ),
        ImageData(
            R.drawable.quicka2, "Tranx\n" +
                    "history"
        ),
        ImageData(
            R.drawable.quicka3, "Contact\n" +
                    "Support"
        ),
        ImageData(
            R.drawable.quicka4, "Rate &\n" +
                    "review"
        )
    )
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(20))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xFFFFFFFF))
                .border(
                    color = Color(0xFF878787),
                    width = .5.dp,
                    shape = RoundedCornerShape(20)
                )
                .padding(bottom = 5.dp)
        ) {
            Text(
                text = "Quick Access",
                fontFamily = urbanistFont,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                for (imgUrl in imageList) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = imgUrl.resoureId, contentDescription = null, modifier = Modifier
                                .size(45.dp)
                        )
                        Text(
                            text = imgUrl.label,
                            fontFamily = urbanistFont,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 17.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

//image slider
@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider() {
    val pagerState = rememberPagerState(initialPage = 5)
    val imageSlider = listOf(
        painterResource(id = R.drawable.img1),
        painterResource(id = R.drawable.img2),
        painterResource(id = R.drawable.img3),
    )
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
    fun lerp(start: Float, stop: Float, fraction: Float): Float {
        return (1 - fraction) * start + fraction * stop
    }
    Box(
        modifier = Modifier.height(IntrinsicSize.Min)
    ) {
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 10.dp),
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                Image(
                    painter = imageSlider[page],
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    }
}

//An alert box for the GPS
@Composable
fun GpsAlert() {
    Box(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 12.dp)
            .clip(RoundedCornerShape(20))
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .border(
                    color = Color(0xFF878787), shape = RoundedCornerShape(20), width = .5.dp
                )
                .height(110.dp),
        ) {
            Row(
                modifier = Modifier.padding(
                    vertical = 10.dp, horizontal = 10.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "location pin",
                    tint = Color(0xFFFF8A00)
                )
                Text(
                    text = "Turn on GPS network for locating nearest services.",
                    fontFamily = urbanistFont,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                horizontalArrangement = Arrangement.End,
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ }, border = BorderStroke(.5.dp, color = StndOrange)
                ) {
                    Text(
                        text = "Cancel",
                        fontFamily = urbanistFont,
                        fontSize = 16.sp,
                        color = StndOrange
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = StndOrange
                    ),
                    border = BorderStroke(.5.dp, color = StndOrange),
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(
                        text = "Turn On",
                        color = Color.White,
                        fontFamily = urbanistFont,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

//Search bar for the main login
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var input by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 12.dp)
            .clip(RoundedCornerShape(20))
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .border(
                    color = Color(0xFF878787), shape = RoundedCornerShape(20), width = .5.dp
                )
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = input,
                onValueChange = {
                    input = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    focusedTextColor = Color.Black
                ),
                singleLine = true,
                placeholder = { Text(text = "Search for services, electricians....") },
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(7.dp),
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
                Divider(
                    color = Color(0xFF8B8B8B), modifier = Modifier
                        .height(30.dp)
                        .width(1.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.microphone_icon),
                    contentDescription = "Mic Icons",
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}