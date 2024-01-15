package com.aaron.bankaccount.ui.screens.checkingscreen

import com.aaron.bankaccount.R
import com.aaron.bankaccount.screenstate.UIState
import com.aaron.bankaccount.di.appresources.AppResources
import com.aaron.bankaccount.framework.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CheckingScreenViewModel @Inject constructor(
    private val appResources: AppResources
) : BaseViewModel() {
    private var _checkingScreenState = MutableStateFlow(getCheckingUiInitialState())
    var checkingScreenState = _checkingScreenState.asStateFlow()
    private val _progressState = MutableStateFlow<UIState>(UIState.Loading)
    val progressState = _progressState.asStateFlow()


    private fun getCheckingUiInitialState(): CheckingScreenUIState {
        return CheckingScreenUIState(
            accountNumberText = appResources.getString(R.string.account_number),
            topTransferDetailInfo = listOf(
                TopTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                TopTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                TopTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                )

            ),
            lastDayDeposit = appResources.getString(R.string.last_day_deposit),
            lastDayDepositAddress = appResources.getString(R.string.last_day_deposit_address),
            lastDayDepositAmount = appResources.getString(R.string.last_day_deposit_amount),
            bottomTransferDetailInfo = listOf(
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ),
                BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                ), BottomTransferInfo(
                    lastDayTransfer = appResources.getString(R.string.last_day_transfer),
                    lastDayTransferAddress = appResources.getString(R.string.last_day_transfer_address),
                    lastDayTransferAmount = appResources.getString(R.string.last_day_transfer_amount),
                )

            )
        )

    }
    fun onEventCheckingScreen(event: CheckingScreenUIEvent) {
        when (event) {
            is CheckingScreenUIEvent.OnClickGoHome -> {
            }

            else -> {}
        }


    }
}