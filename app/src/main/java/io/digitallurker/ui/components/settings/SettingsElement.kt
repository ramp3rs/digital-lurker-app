package io.digitallurker.ui.components.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@Composable
fun SettingsElement(
    icon: ImageVector,
    caption: String,
    isLogout: Boolean = false,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .clip(Measurements.roundedShape)
            .background(
                color = ColorPalette.secondary.copy(alpha = 0.05f),
                shape = Measurements.roundedShape
            )
            .border(
                color = ColorPalette.secondary.copy(alpha = 0.1f),
                shape = Measurements.roundedShape,
                width = 1.5.dp,
            )
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
        ) {
            Spacer(Modifier.width(15.dp))
            Icon(
                icon,
                contentDescription = "Settings element icon",
                tint = when (isLogout) {
                    true -> ColorPalette.red
                    else -> ColorPalette.primary
                }
            )
            Spacer(Modifier.width(5.dp))

            Text(
                caption,
                style = Typing.paragraph.copy(
                    color = when (isLogout) {
                        true -> ColorPalette.red
                        else -> ColorPalette.secondary
                    },
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
    }
}