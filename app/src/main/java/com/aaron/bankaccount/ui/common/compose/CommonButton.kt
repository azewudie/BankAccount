package com.aaron.bankaccount.ui.common.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aaron.bankaccount.ui.theme.CustomTheme

@Composable
fun CommonButton(
    buttonTitle: String,
    color: Color = CustomTheme.colors.logoColor,
    onClick: () -> Unit
) {
    CustomTheme {
        Button(
            modifier = Modifier.width(100.dp),
            onClick = { onClick.invoke() },
            enabled = true,
            shape = ButtonDefaults.shape,
            border = BorderStroke(
                width = CustomTheme.spaces.dp2,
                color = CustomTheme.colors.logoColor,
            ),
            contentPadding = PaddingValues(CustomTheme.spaces.dp0),
            interactionSource = remember {
                MutableInteractionSource()
            },
            colors = ButtonDefaults.buttonColors(containerColor = color)
        ) {
            Text(
                text = buttonTitle,
                textAlign = TextAlign.Center,
                color = CustomTheme.colors.textWhite,
                style = CustomTheme.typography.title1Regular,
                modifier = Modifier.padding(
                    start = CustomTheme.spaces.dp15,
                    top = CustomTheme.spaces.dp8,
                    end = CustomTheme.spaces.dp15,
                    bottom = CustomTheme.spaces.dp8
                )
            )

        }
    }

}