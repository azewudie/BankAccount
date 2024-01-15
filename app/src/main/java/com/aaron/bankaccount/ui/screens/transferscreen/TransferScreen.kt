package com.aaron.bankaccount.ui.screens.transferscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.aaron.bankaccount.R
import com.aaron.bankaccount.ui.common.compose.CommonButton
import com.aaron.bankaccount.screenstate.UIState
import com.aaron.bankaccount.ui.theme.CustomTheme
import com.aaron.bankaccount.utilities.constants.AppConstants


@Composable
fun TransferScreen(
    navController: NavController,
    screenState: State<TransferScreenUIState>,
    progressState: State<UIState>,
    onEvent: (TransferScreenUIEvent) -> Unit,
) {


    CustomTheme {
        Column(
            modifier = Modifier
                .background(color = CustomTheme.colors.backGroundsBG)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFunction(screenState.value.transferToMyFamily)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(CustomTheme.spaces.dp15)
            )
            transferScreenAmountButton(
                firstAmountText = screenState.value.firstRowFirstColumAmount,
                secondAmountText = screenState.value.firstRowSecondColumAmount
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(CustomTheme.spaces.dp15)
            )
            transferScreenAmountButton(
                firstAmountText = screenState.value.secondRowFirstColumAmount,
                secondAmountText = screenState.value.secondRowSecondColumAmount
            )
            TransferScreenBodyInfo(screenState = screenState)
            Spacer(modifier = Modifier.padding(CustomTheme.spaces.dp15))
            CommonButton(
                buttonTitle = screenState.value.firstRowFirstColumAmount,
                color = CustomTheme.colors.statusError01
            ) {

            }

        }
    }

}

@Composable
private fun TextFunction(userInfoText: String) {
    Text(
        text = userInfoText,
        color = CustomTheme.colors.text00,
        style = CustomTheme.typography.largeTitleRegular
    )
}

@Composable
fun transferScreenAmountButton(
    firstAmountText: String, secondAmountText: String
) {
    CustomTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1.0f))
                CommonButton(
                    buttonTitle = firstAmountText,
                    color = CustomTheme.colors.logoColor
                ) {

                }
                Spacer(modifier = Modifier.weight(1.0f))
                CommonButton(
                    buttonTitle = secondAmountText,
                    color = CustomTheme.colors.logoColor
                ) {

                }
                Spacer(modifier = Modifier.weight(1.0f))
            }

        }
    }

}

@Composable
fun TransferScreenLogoTitleAmountText(
    image: Int,
    titleText: String,
    amountText: String

) {
    CustomTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = AppConstants.EMPTY_STRING,
                tint = CustomTheme.colors.action01,
                modifier = Modifier
                    .size(CustomTheme.spaces.dp34)
                    .padding(end = CustomTheme.spaces.dp8)
            )
            Text(
                text = titleText,
                style = CustomTheme.typography.title1Regular,
                color = CustomTheme.colors.text00,
                textAlign = TextAlign.Center
            )
            Text(
                text = amountText,
                style = CustomTheme.typography.title1Regular,
                color = CustomTheme.colors.action01,
                textAlign = TextAlign.Center
            )


        }
    }

}

@Composable
fun TransferScreenArrowDirection() {
    CustomTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                contentDescription = AppConstants.EMPTY_STRING,
                tint = CustomTheme.colors.action01,
                modifier = Modifier
                    .size(CustomTheme.spaces.dp34)
                    .padding(
                        start = CustomTheme.spaces.dp8,
                        end = CustomTheme.spaces.dp8
                    )
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = AppConstants.EMPTY_STRING,
                tint = CustomTheme.colors.action01,
                modifier = Modifier
                    .size(CustomTheme.spaces.dp34)
                    .padding(start = CustomTheme.spaces.dp8, end = CustomTheme.spaces.dp8)
            )
        }
    }
}

@Composable
fun TransferScreenBodyInfo(screenState: State<TransferScreenUIState>) {
    CustomTheme {
        Row(horizontalArrangement = Arrangement.Center) {
            TransferScreenLogoTitleAmountText(
                image = R.drawable.baseline_supervisor_account_24,
                titleText = screenState.value.checkingText,
                amountText = screenState.value.secondRowSecondColumAmount
            )
            Spacer(modifier = Modifier.padding(CustomTheme.spaces.dp8))
            TransferScreenArrowDirection()
            Spacer(modifier = Modifier.padding(CustomTheme.spaces.dp8))
            TransferScreenLogoTitleAmountText(
                image = R.drawable.baseline_supervisor_account_24,
                titleText = screenState.value.myFamilyText,
                amountText = screenState.value.secondRowFirstColumAmount
            )
        }
    }
}