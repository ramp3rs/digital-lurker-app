package io.digitallurker.ui.components.authientication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import io.digitallurker.ui.theme.ColorPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValueField(
    caption: String,
    placeholder: String,
    isPassword: Boolean = false,
) {
    Column {
        Text(caption)

        val fieldValue = remember { mutableStateOf("") }
        TextField(
            value = fieldValue.value,
            onValueChange = { fieldValue.value = it },
            singleLine = true,
            placeholder = { Text(placeholder) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = ColorPalette.secondary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = ColorPalette.primary,
                selectionColors = TextSelectionColors(
                    backgroundColor = ColorPalette.primary,
                    handleColor = ColorPalette.primary,
                ),
            ),
        )
    }
}