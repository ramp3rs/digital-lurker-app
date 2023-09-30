package io.digitallurker.ui.components.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onType: (String) -> Unit) {
    val inputValue = remember { mutableStateOf("") }
    TextField(
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
            onType(it)
        },
        singleLine = true,
        textStyle = Typing.paragraph.copy(
            color = ColorPalette.secondary,
            fontSize = 14.sp,
        ),
        placeholder = {
            Text(
                "Search",
                style = Typing.paragraph.copy(
                    color = ColorPalette.secondary.copy(alpha = 0.3f),
                    fontSize = 14.sp,
                )
            )
        },
        leadingIcon = {
            Icon(
                Icons.Rounded.Search,
                contentDescription = "Search icon",
                tint = ColorPalette.primary,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = ColorPalette.secondary.copy(alpha = 0.05f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = ColorPalette.primary,
            selectionColors = TextSelectionColors(
                backgroundColor = ColorPalette.primary,
                handleColor = ColorPalette.primary,
            ),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(Measurements.textFieldHeight)
            .clip(Measurements.roundedShape)
            .border(
                color = ColorPalette.primary,
                shape = Measurements.roundedShape,
                width = 1.5.dp,
            ),
    )
}