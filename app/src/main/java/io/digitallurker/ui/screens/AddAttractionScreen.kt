package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.components.FullWidthButton
import io.digitallurker.ui.components.UniversalHeader
import io.digitallurker.ui.components.ValueField
import io.digitallurker.ui.components.addattraction.ImageDisplay
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing
import java.io.File

@Composable
fun AddAttractionScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            UniversalHeader(navCtrl, "Add location")

            var image: File? = null
            ImageDisplay { image = it }
            Spacer(Modifier.height(15.dp))

            var name = ""
            ValueField(
                caption = "Name",
                placeholder = "Provide location's name",
            ) { name = it }
            Spacer(Modifier.height(15.dp))

            var description = ""
            ValueField(
                caption = "Description",
                placeholder = "Provide location's description",
            ) { description = it }
            Spacer(Modifier.height(15.dp))

            var experience = ""
            ValueField(
                caption = "Experience",
                placeholder = "Provide location's experience",
                keyboardType = KeyboardType.Number,
            ) { experience = it }
            Spacer(Modifier.height(15.dp))

            var lat = ""
            ValueField(
                caption = "Latitude",
                placeholder = "Provide location's latitude",
                keyboardType = KeyboardType.Decimal,
            ) { lat = it }

            var lng = ""
            ValueField(
                caption = "Longitude",
                placeholder = "Provide location's longitude",
                keyboardType = KeyboardType.Decimal,
            ) { lng = it }
            Spacer(Modifier.height(15.dp))

            FullWidthButton(onClick = { /*TODO*/ }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        "Add location",
                        style = Typing.subHeadline.copy(color = ColorPalette.background),
                        modifier = Modifier.padding(vertical = 10.dp),
                    )
                    Spacer(Modifier.width(5.dp))

                    Icon(
                        Icons.Rounded.Done,
                        contentDescription = "Add location icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

        }
    }
}