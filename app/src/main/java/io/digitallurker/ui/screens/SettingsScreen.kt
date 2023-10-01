package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.components.UniversalHeader
import io.digitallurker.ui.components.settings.SettingsElement
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.utils.PrefsManager

@Composable
fun SettingsScreen(navCtrl: NavController) {
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding),
    ) {
        Column {
            Spacer(Modifier.height(10.dp))
            UniversalHeader(navCtrl = navCtrl, caption = "Settings")

            SettingsElement(
                icon = Icons.Rounded.Edit,
                caption = "Edit profile",
            ) { navCtrl.navigate("/edit-profile") }
            Spacer(Modifier.height(15.dp))

            SettingsElement(
                icon = Icons.Rounded.Lock,
                caption = "Security",
            ) { navCtrl.navigate("/security") }
            Spacer(Modifier.height(15.dp))

            SettingsElement(
                icon = Icons.Rounded.AddCircle,
                caption = "Add new location",
            ) { navCtrl.navigate("/add-attraction") }
            Spacer(Modifier.height(15.dp))

            SettingsElement(
                icon = Icons.Rounded.ExitToApp,
                caption = "Log out",
                isLogout = true,
            ) {
                PrefsManager.getInstance().edit().putString("refresh", "")
                PrefsManager.getInstance().edit().putString("access", "")
                navCtrl.navigate("/login")
            }
        }
    }
}