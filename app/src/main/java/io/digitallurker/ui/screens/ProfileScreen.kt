package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.digitallurker.ui.components.UniversalHeader
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements

@Composable
fun ProfileScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column {
            UniversalHeader(navCtrl, "Your profile")
        }
    }
}