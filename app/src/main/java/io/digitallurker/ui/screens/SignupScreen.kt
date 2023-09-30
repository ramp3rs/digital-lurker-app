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
fun SignupScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column {
            ValueField(caption = "Username", placeholder = "Provide your username")
            ValueField(caption = "E-mail", placeholder = "Provide your e-mail")
            ValueField(
                caption = "Password",
                placeholder = "Your password",
                isPassword = true,
            )
            ValueField(
                caption = "Confirm password",
                placeholder = "Repeat password",
                isPassword = true,
            )
            FullWidthButton(
                onClick = {
                    //TODO signing up user
                    navCtrl.navigate("/home")
                },
            ) {
                Row {
                    Text("Sign up")
                    Icon(
                        Icons.Rounded.ArrowForward,
                        contentDescription = "Sign up button",
                    )
                }
            }
            LoginSignupText(
                navCtrl = navCtrl,
                route = "/login",
                neutralText = "Already have an account?",
                routeText = "Log in.",
            )
        }
    }
}