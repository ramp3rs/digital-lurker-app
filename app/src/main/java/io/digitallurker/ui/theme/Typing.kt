package io.digitallurker.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.digitallurker.R

private val fontFam = FontFamily(
    Font(
        resId = R.font.poppins_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resId = R.font.poppins_thin,
        weight = FontWeight.Thin,
    ),
    Font(
        resId = R.font.poppins_bold,
        weight = FontWeight.Bold,
    ),
)

object Typing {
    val headline = TextStyle(
        color = ColorPalette.secondary,
        fontFamily = fontFam,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )

    val headline2 = TextStyle(
        color = ColorPalette.secondary,
        fontFamily = fontFam,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    )

    val subHeadline = TextStyle(
        color = ColorPalette.secondary,
        fontFamily = fontFam,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    )

    val paragraph = TextStyle(
        color = ColorPalette.secondary,
        fontFamily = fontFam,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )
}