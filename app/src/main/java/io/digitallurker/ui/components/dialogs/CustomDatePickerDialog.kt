package io.digitallurker.ui.components.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import io.digitallurker.ui.theme.ColorPalette
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
    val inputValue = remember { mutableStateOf("") }
    TextField(
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
            onType(it)
        },
    )
}