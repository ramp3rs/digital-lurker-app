package io.digitallurker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.R

@Composable
fun NavBar(navCtrl: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = ColorPalette.background,
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                ),
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(
                painterResource(R.drawable.home_icon),
                contentDescription = "Home page",
                tint = ColorPalette.secondary,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navCtrl.navigate("/home")
                    }
            )
            Icon(
                painterResource(R.drawable.friends_icon),
                contentDescription = "Friends page",
                tint = ColorPalette.secondary,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {

                    },
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable { navCtrl.navigate("/settings") },
            ) {
                Image(
                    painter = painterResource(R.drawable.authientication_img),
                    contentDescription = "Go to settings",
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}