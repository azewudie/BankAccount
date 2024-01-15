package com.aaron.bankaccount.navigation

sealed class AppScreens(val route:String) {
     object AppHomeScreen: AppScreens(AppRouteNames.APP_HOME_SCREEN)
     object CheckingScreen: AppScreens(AppRouteNames.CHECKING_SCREEN)
     object TransferScreen: AppScreens(AppRouteNames.TRANSFER_SCREEN)
     object DisclosuresScreen: AppScreens(AppRouteNames.DISCLOSURES_SCREEN)
     object HelpScreen: AppScreens(AppRouteNames.HELP_SCREEN)
}