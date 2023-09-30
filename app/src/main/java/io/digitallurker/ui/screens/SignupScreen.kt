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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.R
import io.digitallurker.controllers.UserController
import io.digitallurker.ui.components.authientication.AuthienticationHeadline
import io.digitallurker.ui.components.FullWidthButton
import io.digitallurker.ui.components.authientication.DateField
import io.digitallurker.ui.components.authientication.LoginSignupText
import io.digitallurker.ui.components.authientication.ValueField
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.ui.theme.Typing
import io.digitallurker.utils.AuthValidation

@Composable
fun SignupScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {
            Image(
                painter = painterResource(R.drawable.authientication_img),
                contentDescription = "Authentication image",
            )

            AuthienticationHeadline("Become a member!")
            Spacer(Modifier.height(15.dp))

            var usernameValue = ""
            ValueField(
                caption = "Username",
                placeholder = "Provide your username",
            ) { usernameValue = it }
            Spacer(Modifier.height(15.dp))

            var emailValue = ""
            ValueField(
                caption = "E-mail",
                placeholder = "Provide your e-mail",

                ) { emailValue = it }
            Spacer(Modifier.height(15.dp))

            var dateOfBirth = ""
            DateField(
                caption = "Date of birth",
                placeholder = "Your date of birth",
            ) { dateOfBirth = it }
            Spacer(Modifier.height(15.dp))

            var passwordValue = ""
            ValueField(
                caption = "Password",
                placeholder = "Your password",
                isPassword = true,

                ) { passwordValue = it }
            Spacer(Modifier.height(15.dp))

            var passwordConfirmationValue = ""
            ValueField(
                caption = "Confirm password",
                placeholder = "Repeat password",
                isPassword = true,

                ) { passwordConfirmationValue = it }
            Spacer(Modifier.height(15.dp))

            FullWidthButton(
                onClick = {
                    val successfulSignup =
                        UserController.signup(
                            usernameValue,
                            emailValue,
                            passwordValue,
                            dateOfBirth,
                        )
                    if (successfulSignup) {
                        navCtrl.navigate("/home")
                    }
                },
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Sign up",
                        style = Typing.subHeadline.copy(color = ColorPalette.background),
                        modifier = Modifier.padding(vertical = 10.dp),
                    )
                    Spacer(Modifier.width(5.dp))

                    Icon(
                        Icons.Rounded.ArrowForward,
                        contentDescription = "Sign up button",
                        modifier = Modifier.size(20.dp)

                    )
                }
            }
            Spacer(Modifier.height(5.dp))

            LoginSignupText(
                navCtrl = navCtrl,
                route = "/login",
                neutralText = "Already have an account?",
                routeText = "Log in.",
            )
        }
    }
}