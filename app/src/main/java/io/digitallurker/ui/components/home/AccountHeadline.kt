package io.digitallurker.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.digitallurker.ui.theme.Typing
import io.digitallurker.R

@Composable
fun AccountHeadline(navCtrl: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            "Hello!",
            style = Typing.headline,
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.clickable { navCtrl.navigate("/profile") },
        ) {
            Image(
                painter = painterResource(R.drawable.authientication_img),
                contentDescription = "Profile icon",
                modifier = Modifier.size(50.dp)
            )
        }
    }
}