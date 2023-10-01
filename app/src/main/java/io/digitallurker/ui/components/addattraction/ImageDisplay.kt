package io.digitallurker.ui.components.addattraction

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing
import io.digitallurker.utils.ImageConverter
import java.io.File

@Composable
fun ImageDisplay(onSelect: (File) -> Unit) {
    val ctx = LocalContext.current
    val selectedImage = remember { mutableStateOf<Uri?>(null) }

    val imgLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) {
            if (it != null) {
                selectedImage.value = it
                val convertedToFile = ImageConverter.uriToFile(ctx, it)
                if (convertedToFile != null) {
                    onSelect(convertedToFile)
                }
            }
        }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .border(
                color = ColorPalette.secondary.copy(alpha = 0.1f),
                width = 1.5.dp,
                shape = Measurements.roundedShape,
            )
            .clickable {
                imgLauncher.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }
    ) {
        if (selectedImage.value == null) {
            Text(
                "No image selected",
                style = Typing.paragraph.copy(
                    color = ColorPalette.secondary.copy(alpha = 0.4f),
                ),
            )
        } else {
            AsyncImage(
                model = selectedImage.value,
                contentDescription = "Selected image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
    }
}