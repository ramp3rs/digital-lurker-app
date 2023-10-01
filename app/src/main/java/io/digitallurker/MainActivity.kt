package io.digitallurker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.digitallurker.ui.screens.AddAttractionScreen
import io.digitallurker.ui.screens.AttractionScreen
import io.digitallurker.ui.screens.EditProfileScreen
import io.digitallurker.ui.screens.HomeScreen
import io.digitallurker.ui.screens.LoginScreen
import io.digitallurker.ui.screens.SettingsScreen
import io.digitallurker.ui.screens.SignupScreen
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.DigitallurkerTheme
import io.digitallurker.utils.PrefsManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PrefsManager.initialize(this)
        setContent {
            DigitallurkerTheme {
                Surface(
                    color = ColorPalette.background,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(contentAlignment = Alignment.BottomCenter) { App() }
                }
            }
        }
    }
}

@Composable
fun App() {
    val navCtrl = rememberNavController()

    NavHost(
        navController = navCtrl,
        startDestination = "/attraction",
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
    ) {
        composable("/login") { LoginScreen(navCtrl) }
        composable("/signup") { SignupScreen(navCtrl) }
        composable("/home") { HomeScreen(navCtrl) }
        composable("/settings") { SettingsScreen(navCtrl) }
        composable("/edit-profile") { EditProfileScreen(navCtrl) }
        composable("/security") { EditProfileScreen(navCtrl) }
        composable("/add-attraction") { AddAttractionScreen(navCtrl) }
        composable("/attraction") { AttractionScreen(navCtrl) }
    }
}