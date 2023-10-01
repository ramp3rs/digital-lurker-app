package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttractionScreen() {
    BottomSheetScaffold(
        sheetContainerColor = ColorPalette.background,
        containerColor = ColorPalette.background,
        sheetContent = {
            Column {
                Text(
                    "Attraction Name",
                    style = Typing.headline2,
                )
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {

    }
}