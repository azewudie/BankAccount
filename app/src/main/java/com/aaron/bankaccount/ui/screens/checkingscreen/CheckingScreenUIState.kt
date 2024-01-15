package com.aaron.bankaccount.ui.screens.checkingscreen

import com.aaron.bankaccount.utilities.constants.AppConstants

data class CheckingScreenUIState (
    var accountNumberText: String = AppConstants.EMPTY_STRING,
    var topTransferDetailInfo: List<TopTransferInfo> = emptyList(),
    var lastDayDeposit: String = AppConstants.EMPTY_STRING,
    var lastDayDepositAddress: String = AppConstants.EMPTY_STRING,
    var lastDayDepositAmount: String = AppConstants.EMPTY_STRING,
    var bottomTransferDetailInfo: List<BottomTransferInfo> = emptyList()

    )

    data class TopTransferInfo(
        var lastDayTransfer: String = AppConstants.EMPTY_STRING,
        var lastDayTransferAddress: String = AppConstants.EMPTY_STRING,
        var lastDayTransferAmount: String = AppConstants.EMPTY_STRING,
    )

    data class BottomTransferInfo(
        var lastDayTransfer: String = AppConstants.EMPTY_STRING,
        var lastDayTransferAddress: String = AppConstants.EMPTY_STRING,
        var lastDayTransferAmount: String = AppConstants.EMPTY_STRING,
    )

