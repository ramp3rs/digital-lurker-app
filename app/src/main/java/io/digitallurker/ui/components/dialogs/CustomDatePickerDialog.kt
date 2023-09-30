package io.digitallurker.ui.components.dialogs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@Composable
fun CustomDatePickerDialog(onDismiss: (String?) -> Unit) {
    Dialog(onDismissRequest = { onDismiss(null) }) {
        Surface(
            color = ColorPalette.background,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Pick a date",
                    style = Typing.headline2,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InputField(placeholder = "yyyy") {}
                    InputField(placeholder = "mm") {}
                    InputField(placeholder = "dd") {}
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputField(placeholder: String, onType: (String) -> Unit) {
    val isFocused = remember { mutableStateOf(false) }
    val borderColor = animateColorAsState(
        animationSpec = Measurements.colorAnimation(100, 0, LinearEasing),
        targetValue = when (isFocused.value) {
            true -> ColorPalette.primary
            false -> ColorPalette.secondary.copy(alpha = 0.1f)
        },
        label = "",
    )

    val inputValue = remember { mutableStateOf("") }
    TextField(
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
            onType(it)
        },
        singleLine = true,
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
        modifier = Modifier
            .height(Measurements.textFieldHeight)
            .clip(Measurements.roundedShape)
            .border(
                color = borderColor.value,
                shape = Measurements.roundedShape,
                width = 1.5.dp,
            )
            .onFocusChanged { isFocused.value = it.isFocused },

        )
}