package io.digitallurker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Typing

@Composable
fun UniversalHeader(
    navCtrl: NavController,
    caption: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .offset(y = (-1.7).dp)
                .clip(RoundedCornerShape(100))
                .background(
                    color = ColorPalette.secondary,
                    shape = RoundedCornerShape(100),
                )
                .clickable { navCtrl.popBackStack() },
        ) {
            Icon(
                Icons.Rounded.KeyboardArrowLeft,
                contentDescription = "Go back",
                tint = ColorPalette.background,
                modifier = Modifier.size(22.dp),
            )
        }
        Spacer(Modifier.width(10.dp))

        Text(
            caption,
            style = Typing.headline2,
        )
    }
}