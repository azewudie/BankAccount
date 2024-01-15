package com.aaron.bankaccount.ui.common.compose


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarViewDay
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aaron.bankaccount.screenstate.BottomBarScreens
import com.aaron.bankaccount.ui.theme.CustomTheme
import com.aaron.bankaccount.utilities.constants.AppConstants

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    bottomNavigationItem: List<BottomBarScreens>
) {
    CustomTheme {
        NavigationBar(
            containerColor = CustomTheme.colors.cardBgDefault
        ) {
            val currentRoute = currentRoute(navController = navController)
            bottomNavigationItem.forEach { screen ->
                val isSelected = currentRoute?.let { screen.route.contains(it) }
                if (isSelected != null) {
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Unspecified,
                            selectedTextColor = Color.Unspecified,
                            indicatorColor = Color.Unspecified,
                            unselectedIconColor = Color.Unspecified,
                            disabledIconColor = Color.Unspecified,
                            disabledTextColor = Color.Unspecified,
                            unselectedTextColor = Color.Unspecified
                        ),
                        selected = isSelected,
                        onClick = {
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                                navController.graph.startDestinationRoute?.let {
                                    currentRoute?.let {
                                        popUpTo(currentRoute) {
                                            inclusive = inclusive
                                            saveState = true
                                        }
                                    }
                                }
                            }
                        },
                        icon = {
                            when (isSelected) {
                                true -> {
                                    when (screen.sectionName) {
                                        "Accounts" -> {
                                            Icon(
                                                imageVector = Icons.Default.CalendarViewDay,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Profile" -> {
                                            Icon(
                                                imageVector = Icons.Default.AccountCircle,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Disclouser" -> {
                                            Icon(
                                                imageVector = Icons.Default.Folder,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Help" -> {
                                            Icon(
                                                imageVector = Icons.Default.Man,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Playground" -> {
                                            Icon(
                                                imageVector = Icons.Default.WbSunny,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                    }
                                }

                                else -> {
                                    when (screen.sectionName) {
                                        "Accounts" -> {
                                            Icon(
                                                imageVector = Icons.Default.CalendarViewDay,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Profile" -> {
                                            Icon(
                                                imageVector = Icons.Default.AccountCircle,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Disclouser" -> {
                                            Icon(
                                                imageVector = Icons.Default.Folder,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Help" -> {
                                            Icon(
                                                imageVector = Icons.Default.Man,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                        "Playground" -> {
                                            Icon(
                                                imageVector = Icons.Default.WbSunny,
                                                contentDescription = AppConstants.EMPTY_STRING,
                                                tint = CustomTheme.colors.action01,
                                                modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                                            )
                                        }
                                    }
                                }
                            }

                        },
                        label = {
                            ResponsiveText(
                                text = screen.sectionName,
                                color = when (isSelected) {
                                    true -> CustomTheme.colors.action01
                                    else -> CustomTheme.colors.text00
                                },
                                textStyle = CustomTheme.typography.titleBold
                            )
                        }

                    )
                }
            }

        }
    }

}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}