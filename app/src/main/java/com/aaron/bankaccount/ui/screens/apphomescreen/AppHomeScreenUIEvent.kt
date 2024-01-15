package com.aaron.bankaccount.ui.screens.apphomescreen

import androidx.navigation.NavController

sealed class AppHomeScreenUIEvent {
    data class OnClickChecking(val navController: NavController): AppHomeScreenUIEvent()
    data class OnTransferToMyFamily(val navController: NavController): AppHomeScreenUIEvent()
}