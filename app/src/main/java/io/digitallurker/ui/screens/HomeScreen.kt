package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.components.home.AccountHeadline
import io.digitallurker.ui.components.home.SearchBar
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements

@Composable
fun HomeScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding)
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AccountHeadline(navCtrl)
            SearchBar { /* TODO */ }
            Spacer(Modifier.height(15.dp))
//            for (i in 0..10) {
//                AttractionElement(navCtrl, !!!!!!)
//            }
        }
    }
}