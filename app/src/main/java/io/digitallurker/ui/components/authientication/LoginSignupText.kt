package io.digitallurker.ui.components.authientication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import io.digitallurker.ui.theme.Typing

@Composable
fun LoginSignupText(
    navCtrl: NavController,
    route: String,
    neutralText: String,
    routeText: String,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text("$neutralText ", style = Typing.paragraph)
        Text(
            routeText,
            style = Typing.paragraph.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.clickable { navCtrl.navigate(route) })
    }
}