package com.aaron.bankaccount.ui.common.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CommonText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    style: TextStyle,
    textAlign: TextAlign
) {
    Text(
        text = text,
        color = color,
        style = style,
        textAlign = textAlign,
        modifier = modifier

    )
}