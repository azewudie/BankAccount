package com.aaron.bankaccount.ui.screens.transferscreen

import com.aaron.bankaccount.R
import com.aaron.bankaccount.screenstate.UIState
import com.aaron.bankaccount.di.appresources.AppResources
import com.aaron.bankaccount.framework.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TransferScreenViewModel @Inject constructor(private val appResources: AppResources) :
    BaseViewModel() {

    private var _transferScreenState = MutableStateFlow(getTransferUiInitialState())
    var transferScreenState = _transferScreenState.asStateFlow()
    private val _progressState = MutableStateFlow<UIState>(UIState.Loading)
    val progressState = _progressState.asStateFlow()


    private fun getTransferUiInitialState(): TransferScreenUIState {
        return TransferScreenUIState(
            transferToMyFamily= appResources.getString(R.string.transfer_to_my_family),
        firstRowFirstColumAmount = appResources.getString(R.string.first_row_first_colum_amount),
            firstRowSecondColumAmount = appResources.getString(R.string.first_row_second_colum_amount),
            secondRowFirstColumAmount = appResources.getString(R.string.first_row_first_colum_amount),
            secondRowSecondColumAmount = appResources.getString(R.string.second_row_second_colum_amount),
            checkingText= appResources.getString(R.string.checking),
            myFamilyText= appResources.getString(R.string.my_family),


        )
    }
    fun onEventTransferScreen(event: TransferScreenUIEvent) {
        when (event) {
            is TransferScreenUIEvent.OnClickGoHome -> {
            }

            else -> {}
        }


    }


}