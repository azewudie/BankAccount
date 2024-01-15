package com.aaron.bankaccount.screenstate

import com.aaron.bankaccount.navigation.AppScreens

sealed class BottomBarScreens(
    val route:String,
    val sectionName:String,
    val enable:Boolean = false,
) {
    object Account:BottomBarScreens(
        route = AppScreens.AppHomeScreen.route,
        sectionName = "Accounts",
        enable = true
    )
    object Profile:BottomBarScreens(
        route = AppScreens.TransferScreen.route,
        sectionName = "Profile",
        enable = true
    )
    object Disclouser:BottomBarScreens(
        route = AppScreens.DisclosuresScreen.route,
        sectionName = "Disclouser",
        enable = true
    )
    object Help:BottomBarScreens(
        route = AppScreens.HelpScreen.route,
        sectionName = "Help",
        enable = true
    )
    object Playground:BottomBarScreens(
        route = AppScreens.CheckingScreen.route,
        sectionName = "Playground",
        enable = true
    )
}