package com.aaron.bankaccount.ui.screens.apphomescreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.bankaccount.R
import com.aaron.bankaccount.screenstate.UIState
import com.aaron.bankaccount.ui.theme.CustomTheme
import com.aaron.bankaccount.utilities.constants.AppConstants
import kotlinx.coroutines.flow.flow

@Composable
fun AppHomeScreen(
    navController: NavController,
    screenUIState: State<AppHomeScreenUIState>,
    onEvent: (AppHomeScreenUIEvent) -> Unit,
    progressState: State<UIState>
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
                        .fillMaxWidth()
                        .height(CustomTheme.spaces.dp56)
                        .background(color = CustomTheme.colors.logoColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_card_24),
                        contentDescription = AppConstants.EMPTY_STRING,
                        tint = CustomTheme.colors.text00,
                        modifier = Modifier
                            .size(CustomTheme.spaces.dp36)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(CustomTheme.spaces.dp15)
                        .verticalScroll(
                            rememberScrollState()
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    AppHomeScreenHeaderSection(screenUIState = screenUIState)
                    AppHomeScreenFirstRowInfo(
                        screenUIState = screenUIState,
                        onEvent = onEvent,
                        navController = navController
                    )
                    AppHomeScreenSecondRowInfo(screenUIState = screenUIState)
                    AppHomeScreenThirdRowInfo(screenUIState = screenUIState)
                    AppHomeScreenActionText(actionText = screenUIState.value.actionText)
                    AppHomeScreenLastRowInfo(
                        onEvent = onEvent,
                        navController = navController
                    )
                }


            }
        }

    }
}

@Composable
fun AppHomeScreenHeaderSection(screenUIState: State<AppHomeScreenUIState>) {
    CustomTheme {
        Row(
            modifier = Modifier.padding(CustomTheme.spaces.dp15)
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            Text(
                text = screenUIState.value.accountText,
                style = CustomTheme.typography.title1Regular,
                color = CustomTheme.colors.text00,
                modifier = Modifier.weight(1.0f)
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Text(
                text = screenUIState.value.cardsText,
                style = CustomTheme.typography.title1Regular,
                color = CustomTheme.colors.text00,
                modifier = Modifier.weight(1.0f)
            )
            Spacer(modifier = Modifier.weight(0.5f))

        }
    }
}

@Composable
fun AppHomeScreenFirstRowInfo(
    screenUIState: State<AppHomeScreenUIState>,
    onEvent: (AppHomeScreenUIEvent) -> Unit,
    navController: NavController
) {
    CustomTheme {
        Column {
            Row(
                modifier = Modifier
                    .padding(CustomTheme.spaces.dp15)
                    .clickable {
                        onEvent.invoke(AppHomeScreenUIEvent.OnClickChecking(navController = navController))
                    }
            ) {
                AppHomeScreenLogoTextAmountInfo(
                    titleText = screenUIState.value.checkingText,
                    image = R.drawable.baseline_account_circle_24,
                    ammountText = screenUIState.value.checkingAmountText
                )
                Spacer(modifier = Modifier.weight(1.0f))
                AppHomeScreenLogoTextInfo(
                    titleText = screenUIState.value.checkingUserNameText,
                    image = R.drawable.baseline_credit_card_24,
                )

            }
        }

    }
}

@Composable
fun AppHomeScreenSecondRowInfo(screenUIState: State<AppHomeScreenUIState>) {
    CustomTheme {
        Column {
            Row(
                modifier = Modifier.padding(
                    start = CustomTheme.spaces.dp15,
                    end = CustomTheme.spaces.dp15,
                    bottom = CustomTheme.spaces.dp15
                )
            ) {
                AppHomeScreenLogoTextAmountInfo(
                    titleText = screenUIState.value.myFamilyText,
                    image = R.drawable.baseline_supervisor_account_24,
                    ammountText = screenUIState.value.myFamilyAmount
                )
                Spacer(modifier = Modifier.weight(1.0f))
                AppHomeScreenLogoTextInfo(
                    titleText = screenUIState.value.myFamilyName,
                    image = R.drawable.baseline_credit_card_24,
                )

            }
        }

    }
}

@Composable
fun AppHomeScreenThirdRowInfo(screenUIState: State<AppHomeScreenUIState>) {
    CustomTheme {
        Column {
            Row(
                modifier = Modifier.padding(
                    start = CustomTheme.spaces.dp15,
                    end = CustomTheme.spaces.dp15
                )
            ) {
                AppHomeScreenLogoTextAmountInfo(
                    titleText = screenUIState.value.saving,
                    image = R.drawable.baseline_monetization_on_24,
                    ammountText = screenUIState.value.savingAmountText
                )
                Spacer(modifier = Modifier.weight(1.0f))

            }
        }

    }
}

@Composable
fun AppHomeScreenLogoTextAmountInfo(titleText: String, image: Int, ammountText: String) {
    CustomTheme {
        Row(
            modifier = Modifier.padding(CustomTheme.spaces.dp15),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = AppConstants.EMPTY_STRING,
                    tint = CustomTheme.colors.action01,
                    modifier = Modifier
                        .size(CustomTheme.spaces.dp34)
                        .padding(end = CustomTheme.spaces.dp8)
                )
            }
            Column {
                Text(
                    text = titleText,
                    style = CustomTheme.typography.title1Regular,
                    color = CustomTheme.colors.action01
                )
                Text(
                    text = ammountText,
                    style = CustomTheme.typography.title1Regular,
                    color = CustomTheme.colors.action01
                )
            }

        }
    }
}

@Composable
fun AppHomeScreenLogoTextInfo(titleText: String, image: Int) {
    CustomTheme {
        Row(
            modifier = Modifier.padding(CustomTheme.spaces.dp15),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = AppConstants.EMPTY_STRING,
                tint = CustomTheme.colors.action01,
                modifier = Modifier
                    .size(CustomTheme.spaces.dp30)
                    .padding(end = CustomTheme.spaces.dp8)
            )
            Text(
                text = titleText,
                style = CustomTheme.typography.title1Regular,
                color = CustomTheme.colors.action01
            )

        }
    }
}

@Composable
fun AppHomeScreenActionText(actionText: String) {
    CustomTheme {
        Column(
            modifier = Modifier.padding(CustomTheme.spaces.dp15),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = actionText,
                style = CustomTheme.typography.title1Regular,
                color = CustomTheme.colors.text00,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AppHomeScreenLastRowInfo(
    onEvent: (AppHomeScreenUIEvent) -> Unit,
    navController: NavController
) {
    CustomTheme {
        Column(modifier = Modifier.padding(CustomTheme.spaces.dp15)) {
            Row {
                AppHomeScreenLogoColumInfoText(
                    textInfoFirstRow = "Transfer To",
                    textInfoSecondRow = "My Family",
                    image = R.drawable.baseline_supervisor_account_24
                ) {
                    onEvent.invoke(AppHomeScreenUIEvent.OnTransferToMyFamily(navController = navController))
                }
                Spacer(modifier = Modifier.weight(1.0f))
                AppHomeScreenLogoColumInfoText(
                    textInfoFirstRow = "Transfer To",
                    textInfoSecondRow = "Savings",
                    image = R.drawable.baseline_monetization_on_24
                ) {}
                Spacer(modifier = Modifier.weight(1.0f))

                AppHomeScreenLogoColumInfoText(
                    textInfoFirstRow = "Deposit a",
                    textInfoSecondRow = "Check",
                    image = R.drawable.baseline_shopping_bag_24
                ) {}
            }

        }
    }
}

@Composable
fun AppHomeScreenLogoColumInfoText(
    textInfoFirstRow: String,
    textInfoSecondRow: String,
    image: Int,
    onClick: () -> Unit
) {
    CustomTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                onClick.invoke()
            }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = AppConstants.EMPTY_STRING,
                    tint = CustomTheme.colors.action01,
                    modifier = Modifier
                        .size(CustomTheme.spaces.dp30)
                        .padding(bottom = CustomTheme.spaces.dp8)
                )
            }
            Column {
                Text(
                    text = textInfoFirstRow,
                    style = CustomTheme.typography.title3Regular,
                    color = CustomTheme.colors.action01,
                    textAlign = TextAlign.Center,
                    minLines = 1
                )
            }
            Text(
                text = textInfoSecondRow,
                style = CustomTheme.typography.title3Regular,
                color = CustomTheme.colors.action01,
                textAlign = TextAlign.Center,
                minLines = 1
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark mode"
)
@Composable
private fun PreviewAppHomeScreen() {
    CustomTheme {
        AppHomeScreen(
            navController = rememberNavController(),
            screenUIState = flow<AppHomeScreenUIState> {}.collectAsState(
                initial = AppHomeScreenUIState(
                    accountText = stringResource(R.string.account),
                    cardsText = stringResource(R.string.cards),
                    checkingText = stringResource(R.string.checking),
                    checkingAmountText = stringResource(R.string.checking_amount),
                    checkingUserNameText = stringResource(R.string.checking_user_name),
                    myFamilyText = stringResource(R.string.my_family),
                    myFamilyAmount = stringResource(R.string.my_family_amount),
                    myFamilyName = stringResource(R.string.my_family_name),
                    saving = stringResource(R.string.saving),
                    savingAmountText = stringResource(R.string.saving_amount),
                    actionText = stringResource(R.string.action),
                    transferToFamilyText = stringResource(R.string.transfer_to_family),
                    transferToSavings = stringResource(R.string.transfer_to_savings),
                    depositToCheckText = stringResource(R.string.deposit_a_check),
                )
            ),
            onEvent = {},
            progressState = flow<UIState> {}.collectAsState(initial = UIState.Success)
        )
    }
}