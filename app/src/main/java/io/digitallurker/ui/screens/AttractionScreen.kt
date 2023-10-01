package io.digitallurker.ui.screens

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.R
import io.digitallurker.models.Attraction
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@Composable
fun AttractionScreen(
    navCtrl: NavController,
//    attraction: Attraction,
) {
    val deviceMetrics = Resources.getSystem().displayMetrics
    val deviceHeight = (deviceMetrics.heightPixels / deviceMetrics.density).dp
    val imageHeight = 180.dp
    Surface(
        color = ColorPalette.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(contentAlignment = Alignment.BottomCenter) {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxHeight()
            ) {
                Image(
                    painterResource(R.drawable.example_img),
                    contentDescription = "Image of attraction",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight),
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(deviceHeight - imageHeight + 30.dp)
                    .background(
                        color = ColorPalette.background, shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp,
                        )
                    ),
            ) {
                Column(modifier = Modifier.padding(horizontal = Measurements.screenPadding)) {
                    Spacer(Modifier.height(Measurements.screenPadding))
                    Text(
                        "Attraction's name",
                        style = Typing.headline2,
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "Location",
                            tint = ColorPalette.primary.copy(alpha = 1f),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(2.5.dp))
                        Text(
                            "Warsaw, Poland",
                            style = Typing.paragraph.copy(color = ColorPalette.primary),
                        )
                    }
                    Spacer(Modifier.height(15.dp))

                    Text(
                        "Description",
                        style = Typing.headline2,
                    )
                    Text(
                        "ashdgasgddjhadghjdghdasghdshjsdghsdghjdgjdhsasdsdsdsdahjghjghjsdahjghasdghjaghjghjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjsdashdgasgddjhadghjdghdasghdshjsdghsdghjdgjdhsasdsdsdsdahjghjghjsdahjghasdghjaghjghjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjsd",
                        style = Typing.paragraph,
                    )
                    Spacer(Modifier.height(15.dp))

                    Text(
                        "Photos of others",
                        style = Typing.headline2,
                    )
                    Row(Modifier.horizontalScroll(rememberScrollState())) {
                        for (i in 0..11) {
                            Image(
                                painterResource(R.drawable.example_img),
                                contentDescription = "Photos",
                                modifier = Modifier
                                    .height(imageHeight)
                                    .clip(Measurements.roundedShape),
                            )
                            Spacer(Modifier.width(15.dp))
                        }
                    }

                }
            }
        }
    }
}