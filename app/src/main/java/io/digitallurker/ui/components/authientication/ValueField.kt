package io.digitallurker.ui.components.authientication

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValueField(
    caption: String,
    placeholder: String,
    isPassword: Boolean = false,
    onType: (String) -> Unit,
) {
    Column {
        Text(
            caption,
            style = Typing.paragraph.copy(color = ColorPalette.secondary.copy(alpha = 0.65f)),
        )

        val fieldValue = remember { mutableStateOf("") }
        val isFocused = remember { mutableStateOf(false) }

        val borderColor = animateColorAsState(
            animationSpec = Measurements.colorAnimation(100, 0, LinearEasing),
            targetValue = when (isFocused.value) {
                true -> ColorPalette.primary
                false -> ColorPalette.secondary.copy(alpha = 0.1f)
            },
            label = "",
        )
        TextField(
            value = fieldValue.value,
            onValueChange = {
                fieldValue.value = it
                onType(it)
            },
            singleLine = true,
            placeholder = {
                Text(
                    placeholder,
                    style = Typing.paragraph.copy(
                        color = ColorPalette.secondary.copy(alpha = 0.3f),
                        fontSize = 14.sp,
                    )
                )
            },
            textStyle = Typing.paragraph.copy(
                color = ColorPalette.secondary,
                fontSize = 14.sp,
            ),
            keyboardOptions = when (isPassword) {
                true -> KeyboardOptions(keyboardType = KeyboardType.Password)
                false -> KeyboardOptions.Default
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
                .height(Measurements.textFieldHeight)
                .clip(Measurements.roundedShape)
                .border(
                    color = borderColor.value,
                    shape = Measurements.roundedShape,
                    width = 1.5.dp,
                )
                .fillMaxWidth()
                .onFocusChanged { isFocused.value = it.isFocused },
        )
    }
}