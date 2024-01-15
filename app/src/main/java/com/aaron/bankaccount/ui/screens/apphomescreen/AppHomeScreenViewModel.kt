package com.aaron.bankaccount.ui.screens.apphomescreen

import com.aaron.bankaccount.R
import com.aaron.bankaccount.di.appresources.AppResources
import com.aaron.bankaccount.screenstate.UIState
import com.aaron.bankaccount.framework.base.viewModel.BaseViewModel
import com.aaron.bankaccount.navigation.AppScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AppHomeScreenViewModel @Inject constructor(
    private val appResources: AppResources
) : BaseViewModel() {

    private val _appHomeScreenState = MutableStateFlow(getAppHomeScreenUiInitialState())
    val appHomeScreenState = _appHomeScreenState.asStateFlow()
    private val _progressState = MutableStateFlow<UIState>(UIState.Loading)
    val progressState = _progressState.asStateFlow()
    private fun getAppHomeScreenUiInitialState(): AppHomeScreenUIState {
        return AppHomeScreenUIState(
            accountText = appResources.getString(R.string.account),
            cardsText = appResources.getString(R.string.cards),
            checkingText = appResources.getString(R.string.checking),
            checkingAmountText = appResources.getString(R.string.checking_amount),
            checkingUserNameText = appResources.getString(R.string.checking_user_name),
            myFamilyText = appResources.getString(R.string.my_family),
            myFamilyAmount = appResources.getString(R.string.my_family_amount),
            myFamilyName = appResources.getString(R.string.my_family_name),
            saving = appResources.getString(R.string.saving),
            savingAmountText = appResources.getString(R.string.saving_amount),
            actionText = appResources.getString(R.string.action),
            transferToFamilyText = appResources.getString(R.string.transfer_to_family),
            transferToSavings = appResources.getString(R.string.transfer_to_savings),
            depositToCheckText = appResources.getString(R.string.deposit_a_check),
        )
    }


    fun onAppHomeEvent(event: AppHomeScreenUIEvent) {
        when (event) {
            is AppHomeScreenUIEvent.OnClickChecking -> {
                event.navController.navigate(AppScreens.CheckingScreen.route)
            }

            is AppHomeScreenUIEvent.OnTransferToMyFamily -> {
                event.navController.navigate(AppScreens.TransferScreen.route)

            }
        }

    }


}