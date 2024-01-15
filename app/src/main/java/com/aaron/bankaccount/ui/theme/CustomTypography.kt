package com.aaron.bankaccount.ui.theme


import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class CustomTypography(
    val title1Regular: TextStyle,
    val title2Regular: TextStyle,
    val title3Regular: TextStyle,
    val largeTitleRegular:TextStyle,
    val textFieldError: TextStyle,
    val titleBold: TextStyle,
    val bodyLink:TextStyle
)

val LocalTypography = staticCompositionLocalOf {
    CustomTypography(
        title1Regular = TextStyle.Default,
        title2Regular = TextStyle.Default,
        title3Regular = TextStyle.Default,
        largeTitleRegular = TextStyle.Default,
        textFieldError = TextStyle.Default,
        titleBold = TextStyle.Default,
        bodyLink = TextStyle.Default
    )
}
