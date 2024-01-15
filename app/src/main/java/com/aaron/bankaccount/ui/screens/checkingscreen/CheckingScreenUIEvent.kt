package com.aaron.bankaccount.ui.screens.checkingscreen

import androidx.navigation.NavController

sealed class CheckingScreenUIEvent {
    data class OnClickGoHome(val navController: NavController): CheckingScreenUIEvent()
}