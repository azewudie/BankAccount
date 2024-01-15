package com.aaron.bankaccount.ui.screens.checkingscreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.aaron.bankaccount.R
import com.aaron.bankaccount.screenstate.UIState
import com.aaron.bankaccount.ui.theme.CustomTheme
import com.aaron.bankaccount.utilities.constants.AppConstants

@Composable
fun CheckingScreen(
    navController: NavController,
    screenState: State<CheckingScreenUIState>,
    progressState: State<UIState>,
    onEvent: (CheckingScreenUIEvent) -> Unit,
) {
    CustomTheme {
        Surface(modifier = Modifier.background(CustomTheme.colors.cardBgDefault)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = CustomTheme.colors.cardBgDefault)
            ) {
                Column(
                    modifier = Modifier
                        .padding(CustomTheme.spaces.dp15)
                        .verticalScroll(
                            rememberScrollState()
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    CheckingScreenHeaderText(screenState = screenState)
                    Spacer(
                        modifier = Modifier
                            .background(color = CustomTheme.colors.text02)
                            .fillMaxWidth()
                            .height(CustomTheme.spaces.dp15)
                    )
                    screenState.value.topTransferDetailInfo.forEach { data ->
                        CheckingScreenTransferInfo(
                            transferDayText = data.lastDayTransfer,
                            transferAddressText = data.lastDayTransferAddress,
                            amountTransferText = data.lastDayTransferAmount
                        )

                    }
                    CheckingScreenDepositInfo(
                        transferDayText = screenState.value.lastDayDeposit,
                        transferAddressText = screenState.value.lastDayDepositAddress,
                        amountTransferText = screenState.value.lastDayDepositAmount
                    )
                    screenState.value.bottomTransferDetailInfo.forEach { data ->
                        CheckingScreenTransferInfo(
                            transferDayText = data.lastDayTransfer,
                            transferAddressText = data.lastDayTransferAddress,
                            amountTransferText = data.lastDayTransferAmount
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun CheckingScreenHeaderText(screenState: State<CheckingScreenUIState>) {
    CustomTheme {
        Row(modifier = Modifier.padding(CustomTheme.spaces.dp15)) {
            Text(
                text = screenState.value.accountNumberText,
                style = CustomTheme.typography.title3Regular,
                color = CustomTheme.colors.text00,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Text(
                text = screenState.value.lastDayDepositAmount,
                style = CustomTheme.typography.title3Regular,
                color = CustomTheme.colors.text00,
                textAlign = TextAlign.End
            )

        }
    }
}

@Composable
fun CheckingScreenDepositInfo(
    transferDayText: String,
    transferAddressText: String,
    amountTransferText: String
) {
    CustomTheme {
        Column {
            Row {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_box_24),
                        contentDescription = AppConstants.EMPTY_STRING,
                        tint = androidx.compose.ui.graphics.Color.Green,
                        modifier = Modifier
                            .size(CustomTheme.spaces.dp34)
                            .padding(end = CustomTheme.spaces.dp8)
                    )
                    Column {
                        Text(
                            text = transferDayText,
                            style = CustomTheme.typography.title3Regular,
                            color = CustomTheme.colors.logoColor,
                            textAlign = TextAlign.End
                        )
                        Text(
                            text = transferAddressText,
                            style = CustomTheme.typography.title3Regular,
                            color = CustomTheme.colors.text02,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1.0f))
                Text(
                    text = amountTransferText,
                    style = CustomTheme.typography.title3Regular,
                    color = CustomTheme.colors.text00,
                    textAlign = TextAlign.End
                )
            }
            Spacer(
                modifier = Modifier
                    .background(color = CustomTheme.colors.text02)
                    .fillMaxWidth()
                    .height(CustomTheme.spaces.dp2)
            )
        }

    }
}

@Composable
fun CheckingScreenTransferInfo(
    transferDayText: String,
    transferAddressText: String,
    amountTransferText: String
) {
    CustomTheme {
        Column {
            Row {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_indeterminate_check_box_24),
                        contentDescription = AppConstants.EMPTY_STRING,
                        tint = androidx.compose.ui.graphics.Color.Red,
                        modifier = Modifier
                            .size(CustomTheme.spaces.dp34)
                            .padding(end = CustomTheme.spaces.dp8)
                    )
                    Column {
                        Text(
                            text = transferDayText,
                            style = CustomTheme.typography.title3Regular,
                            color = CustomTheme.colors.text00,
                            textAlign = TextAlign.End
                        )
                        Text(
                            text = transferAddressText,
                            style = CustomTheme.typography.title3Regular,
                            color = CustomTheme.colors.text02,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1.0f))
                Text(
                    text = amountTransferText,
                    style = CustomTheme.typography.title3Regular,
                    color = CustomTheme.colors.text00,
                    textAlign = TextAlign.End
                )
            }
            Spacer(
                modifier = Modifier
                    .background(color = CustomTheme.colors.text02)
                    .fillMaxWidth()
                    .height(CustomTheme.spaces.dp2)
            )
        }

    }
}

