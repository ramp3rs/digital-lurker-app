package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.digitallurker.ui.components.authientication.FullWidthButton
import io.digitallurker.ui.components.authientication.LoginSignupText
import io.digitallurker.ui.components.authientication.ValueField
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements

@Composable
fun LoginScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column {
            ValueField("Username", "Provide your username")
            ValueField("Password", "Provide your password", true)
            FullWidthButton(
                onClick = {
                    // TODO logging in user
                    navCtrl.navigate("/home")
                },
            ) {
                Row {
                    Text("Log in")
                    Icon(
                        Icons.Rounded.ArrowForward,
                        contentDescription = "Log in button"
                    )
                }
            }
            LoginSignupText(
                navCtrl = navCtrl,
                route = "/signup",
                neutralText = "Don't have an account?",
                routeText = "Sign Up."
            )
        }
    }
}