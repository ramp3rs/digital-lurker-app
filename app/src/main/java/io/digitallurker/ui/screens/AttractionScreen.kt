package io.digitallurker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.R
import io.digitallurker.models.Attraction

@Composable
fun AttractionScreen(attraction: Attraction) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Box {
            Image(
                painterResource(R.drawable.example_img),
                contentDescription = "Image of attraction",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(),
            )
            Box(modifier = Modifier.fillMaxWidth()) {

            }
        }
    }
}