package io.digitallurker.ui.theme

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object Measurements {
    val screenPadding = 20.dp
    val roundedShape = RoundedCornerShape(12.5.dp)
    val textFieldHeight = 52.dp

    fun <T> colorAnimation(
        duration: Int = 125,
        delay: Int = 0,
        easing: Easing = LinearOutSlowInEasing
    ): TweenSpec<T> =
        tween(duration, delay, easing)
}