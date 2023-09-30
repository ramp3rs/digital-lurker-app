package io.digitallurker.ui.components.authientication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun LoginSignupText(
    navCtrl: NavController,
    route: String,
    neutralText: String,
    routeText: String,
) {
    Row {
        Text("$neutralText ")
        Text(routeText, modifier = Modifier.clickable { navCtrl.navigate(route) })
    }
}