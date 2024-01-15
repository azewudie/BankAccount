package com.aaron.bankaccount.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = CustomColors(
    text00 = Color(0xFFF3F3F8),
    text01 = Color(0xFFCBCED9),
    text02 = Color(0xFF949A9F),
    textWhite = Color(0xFFF3F3F8),
    backGroundsBG = Color(0xFF061F2D),
    cardBgDefault = Color(0xFF202441),
    action01 = Color(0xFFFF6D05),
    statusError01 = Color(0xFFFF6961),
    logoColor = Color(0xFF2E4662)

)

private val LightColorScheme = CustomColors(
    text00 = Color(0xFF29353A),
    text01 = Color(0xFF00FF00),
    text02 = Color(0xFF7C858D),
    textWhite = Color(0xFFF3F3F8),
    backGroundsBG = Color(0xFFF3F3F8),
    cardBgDefault = Color(0xFFFCFCFc),
    action01 = Color(0xFF0670F6),
    statusError01 = Color(0xFFFF6D05),
    logoColor = Color(0xFF008000)
)

@Composable
fun getColors(): CustomColors {
    return if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
}

@Composable
fun getTypography(): CustomTypography {
    return CustomTypography(
        title1Regular = TextStyle(
            fontWeight = FontWeight(700),
            fontSize = 22.sp,
            lineHeight = 17.sp
        ),
        title2Regular = TextStyle(
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            lineHeight = 17.sp
        ),
        title3Regular = TextStyle(
            fontWeight = FontWeight(700),
            fontSize = 17.sp,
            lineHeight = 17.sp
        ),
        largeTitleRegular = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 11.sp,
            lineHeight = 13.sp
        ),
        textFieldError = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 11.sp,
            lineHeight = 13.sp
        ),
        titleBold = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 11.sp,
            lineHeight = 13.sp
        ),
        bodyLink = TextStyle(
            fontWeight = FontWeight(400),
            fontSize = 11.sp,
            lineHeight = 13.sp
        )

    )
}

@Composable
fun getDimension(): CustomDimensions {
    return CustomDimensions()
}

@Composable
fun CustomTheme(
    spaces: CustomDimensions = getDimension(),
    typography: CustomTypography = getTypography(),
    colors: CustomColors = getColors(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    val darkTheme = isSystemInDarkTheme()
    if (!view.isInEditMode) {
        val systemUiController =rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = colors.backGroundsBG,
                darkIcons = !darkTheme
            )
        }
    }
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalDimensions provides spaces,
        LocalTypography provides typography
    ) {
        content()
    }

}