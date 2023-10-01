package io.digitallurker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.controllers.UserController
import io.digitallurker.ui.components.authientication.AuthienticationHeadline
import io.digitallurker.ui.components.FullWidthButton
import io.digitallurker.ui.components.authientication.LoginSignupText
import io.digitallurker.ui.components.authientication.ValueField
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing
import io.digitallurker.R
import io.digitallurker.utils.PrefsManager

@Composable
fun LoginScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.authientication_img),
                contentDescription = "Authientication image",
            )

            AuthienticationHeadline("Welcome back!")
            Spacer(Modifier.height(15.dp))

            var emailValue = ""
            ValueField(
                caption = "E-mail",
                placeholder = "Provide your e-mail",
            ) { emailValue = it }

            Spacer(Modifier.height(15.dp))

            var passwordValue = ""
            ValueField(
                caption = "Password",
                placeholder = "Provide your password",
                isPassword = true,
            ) { passwordValue = it }

            Spacer(Modifier.height(15.dp))

            FullWidthButton(
                onClick = {
                    val res = UserController.login(emailValue, passwordValue)
                    println(res)
                    if (res!=null) {
                        println(PrefsManager.getInstance().getString("refresh", "error"))
                        println(PrefsManager.getInstance().getString("access", "error"))
                        navCtrl.navigate("/home")
                    }
                },
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Log in",
                        style = Typing.subHeadline.copy(color = ColorPalette.background),
                        modifier = Modifier.padding(vertical = 10.dp),
                    )
                    Spacer(Modifier.width(5.dp))

                    Icon(
                        Icons.Rounded.ArrowForward,
                        contentDescription = "Log in button",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Spacer(Modifier.height(5.dp))

            LoginSignupText(
                navCtrl = navCtrl,
                route = "/signup",
                neutralText = "Don't have an account?",
                routeText = "Sign Up."
            )
        }
    }
}