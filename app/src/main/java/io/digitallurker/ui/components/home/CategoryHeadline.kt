package io.digitallurker.ui.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Typing

@Composable
fun CategoryHeadline(caption: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            caption,
            style = Typing.headline2,
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
        ) {
            Text(
                "See all",
                style = Typing.paragraph.copy(color = ColorPalette.primary),
            )
        }
    }
}