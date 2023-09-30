package io.digitallurker.ui.components.authientication

import android.icu.util.Measure
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.digitallurker.ui.components.dialogs.CustomDatePickerDialog
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing

@Composable
fun DateField(
    caption: String,
    placeholder: String,
    onValueSelect: (String) -> Unit,
) {
    val showDatePicker = remember { mutableStateOf(false) }

    val inputValue = remember { mutableStateOf<String?>(null) }
    Column {
        Text(
            caption,
            style = Typing.paragraph.copy(color = ColorPalette.secondary.copy(alpha = 0.65f)),
        )
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .height(Measurements.textFieldHeight)
                .height(Measurements.textFieldHeight)
                .clip(Measurements.roundedShape)
                .background(
                    color = ColorPalette.secondary.copy(alpha = 0.05f),
                    shape = Measurements.roundedShape,
                )
                .border(
                    color = ColorPalette.secondary.copy(alpha = 0.1f),
                    shape = Measurements.roundedShape,
                    width = 1.5.dp,
                )
                .fillMaxWidth()
                .clickable { showDatePicker.value = true },
        ) {
            Row {
                Spacer(Modifier.width(16.dp))
                Text(
                    text = when (inputValue.value) {
                        null -> placeholder
                        else -> inputValue.value!!
                    },
                    style = Typing.paragraph.copy(
                        color = ColorPalette.secondary.copy(alpha = 0.3f),
                        fontSize = 14.sp,
                    ),
                )
            }
        }
    }

    if (showDatePicker.value) {
        CustomDatePickerDialog {
            if (it != null) onValueSelect(it)
            showDatePicker.value = false
        }
    }
}