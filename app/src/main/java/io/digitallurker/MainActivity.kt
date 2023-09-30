package io.digitallurker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.digitallurker.ui.screens.HomeScreen
import io.digitallurker.ui.screens.LoginScreen
import io.digitallurker.ui.screens.SignupScreen
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.DigitallurkerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitallurkerTheme {
                Surface(
                    color = ColorPalette.background,
                    modifier = Modifier.fillMaxSize(),
                ) { App() }
            }
        }
    }
}

@Composable
fun App() {
    val navCtrl = rememberNavController()

    NavHost(
        navController = navCtrl,
        startDestination = "/login",
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
    ) {
        composable("/login") { LoginScreen(navCtrl) }
        composable("/signup") { SignupScreen(navCtrl) }
        composable("/home") { HomeScreen(navCtrl) }
    }
}