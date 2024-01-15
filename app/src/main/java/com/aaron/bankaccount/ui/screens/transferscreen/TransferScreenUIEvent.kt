package com.aaron.bankaccount.ui.screens.transferscreen

import androidx.navigation.NavController

sealed class TransferScreenUIEvent {
    data class OnClickGoHome(val navController: NavController): TransferScreenUIEvent()

}