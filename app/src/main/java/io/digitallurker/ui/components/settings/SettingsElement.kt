package io.digitallurker.ui.components.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Typing

@Composable
fun SettingsElement(
    icon: ImageVector,
    caption: String,
    onClick: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                icon,
                contentDescription = "",
                tint = ColorPalette.primary,
            )
            Text(
                caption,
                style = Typing.paragraph.copy(fontWeight = FontWeight.Bold),
            )
        }
    }
}