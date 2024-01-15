package com.aaron.bankaccount.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val text00: Color,
    val text01: Color,
    val text02: Color,
    val textWhite: Color,
    val backGroundsBG: Color,
    val cardBgDefault: Color,
    val action01: Color,
    val statusError01: Color,
    val logoColor:Color
)

val LocalColors = staticCompositionLocalOf {
    CustomColors(
        text00 = Color.Unspecified,
        text01 = Color.Unspecified,
        text02 = Color.Unspecified,
        textWhite = Color.Unspecified,
        backGroundsBG = Color.Unspecified,
        cardBgDefault = Color.Unspecified,
        action01 = Color.Unspecified,
        statusError01 = Color.Unspecified,
        logoColor = Color.Unspecified
    )
}
