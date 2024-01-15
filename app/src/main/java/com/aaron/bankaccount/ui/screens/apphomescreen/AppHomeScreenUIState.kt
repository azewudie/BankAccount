package com.aaron.bankaccount.ui.screens.apphomescreen

import com.aaron.bankaccount.utilities.constants.AppConstants

data class AppHomeScreenUIState(
    val accountText:String = AppConstants.EMPTY_STRING,
    val cardsText:String = AppConstants.EMPTY_STRING,
    val emailValueText:String = AppConstants.EMPTY_STRING,
    val checkingText:String = AppConstants.EMPTY_STRING,
    val checkingAmountText:String = AppConstants.EMPTY_STRING,
    val checkingUserNameText:String = AppConstants.EMPTY_STRING,
    var myFamilyText:String = AppConstants.EMPTY_STRING,
    var myFamilyAmount:String = AppConstants.EMPTY_STRING,
    var myFamilyName:String = AppConstants.EMPTY_STRING,
    var saving:String = AppConstants.EMPTY_STRING,
    var savingAmountText:String = AppConstants.EMPTY_STRING,
    var  actionText:String = AppConstants.EMPTY_STRING,
    var transferToFamilyText:String = AppConstants.EMPTY_STRING,
    var transferToSavings:String = AppConstants.EMPTY_STRING,
    var depositToCheckText:String = AppConstants.EMPTY_STRING,
)