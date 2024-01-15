package com.aaron.bankaccount.ui.screens.transferscreen

import com.aaron.bankaccount.utilities.constants.AppConstants

data class TransferScreenUIState(
    var transferToMyFamily: String = AppConstants.EMPTY_STRING,
    var firstRowFirstColumAmount: String = AppConstants.EMPTY_STRING,
    var firstRowSecondColumAmount: String = AppConstants.EMPTY_STRING,
    var secondRowFirstColumAmount: String = AppConstants.EMPTY_STRING,
    var secondRowSecondColumAmount: String = AppConstants.EMPTY_STRING,
    val checkingText:String = AppConstants.EMPTY_STRING,
    var myFamilyText:String = AppConstants.EMPTY_STRING,


)

