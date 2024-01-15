package com.aaron.bankaccount.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aaron.bankaccount.screenstate.BottomBarScreens
import com.aaron.bankaccount.ui.common.compose.BottomNavigationBar
import com.aaron.bankaccount.ui.screens.apphomescreen.AppHomeScreen
import com.aaron.bankaccount.ui.screens.apphomescreen.AppHomeScreenViewModel
import com.aaron.bankaccount.ui.screens.checkingscreen.CheckingScreen
import com.aaron.bankaccount.ui.screens.checkingscreen.CheckingScreenViewModel
import com.aaron.bankaccount.ui.screens.transferscreen.TransferScreen
import com.aaron.bankaccount.ui.screens.transferscreen.TransferScreenViewModel
import com.aaron.bankaccount.ui.theme.CustomTheme
import com.aaron.bankaccount.utilities.constants.AppConstants

typealias SheetContent = @Composable ColumnScope.() -> Unit

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun AppNavigation(navHostController: NavHostController = rememberNavController()) {
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    var currentScreen: String = AppScreens.AppHomeScreen.route
    backStackEntry?.destination?.route?.let {
        currentScreen = it
    }
    val bottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val bottomSheetConstants: SheetContent? by remember {
        mutableStateOf(null)
    }
    val defaultBackButtonHandler: () -> Unit = { navHostController.navigateUp() }
    var showTitle by rememberSaveable { mutableStateOf(false) }
    var showTopAppBar by rememberSaveable { mutableStateOf(false) }
    val navigationBackEntry by navHostController.currentBackStackEntryAsState()
    showTitle = when (navigationBackEntry?.destination?.route) {
        AppScreens.CheckingScreen.route -> true
        else -> false

    }
    showTopAppBar = when (navigationBackEntry?.destination?.route) {
        AppScreens.AppHomeScreen.route -> false
        else -> true

    }
    val bottomNavigationItem = listOf(
        BottomBarScreens.Account,
        BottomBarScreens.Profile,
        BottomBarScreens.Disclouser,
        BottomBarScreens.Help,
        BottomBarScreens.Playground

    )
    val vmStoreOwner = rememberViewModelStoreOwner()
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = { bottomSheetConstants?.invoke(this) },
        sheetShape = RoundedCornerShape(
            topStart = CustomTheme.spaces.dp13,
            topEnd = CustomTheme.spaces.dp13
        ),

        ) {
        Scaffold(
            containerColor = CustomTheme.colors.cardBgDefault,
            topBar = {
                if (showTopAppBar) {
                    CommonAppBar(
                        currentScreen = getScreenTitle(currentScreen),
                        canNavigateBack = navHostController.previousBackStackEntry != null,
                        navigateUp = defaultBackButtonHandler,
                        hideScreenTittle = showTitle
                    )
                }
            },
            bottomBar = {
                BottomNavigationBar(
                    navController = navHostController,
                    bottomNavigationItem = bottomNavigationItem

                )
            }
        ) { innerPadding ->
            CompositionLocalProvider(LocalNavGraphViewModelStoreOwner provides vmStoreOwner) {
                NavHost(
                    navController = navHostController,
                    startDestination = AppScreens.AppHomeScreen.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = AppScreens.AppHomeScreen.route) {
                        val viewModel: AppHomeScreenViewModel = hiltViewModel()
                        val screenState = viewModel.appHomeScreenState.collectAsStateWithLifecycle()
                        val progressState = viewModel.progressState.collectAsStateWithLifecycle()
                        AppHomeScreen(
                            navController = navHostController,
                            screenUIState = screenState,
                            progressState = progressState,
                            onEvent = viewModel::onAppHomeEvent
                        )

                    }
                    composable(route = AppScreens.CheckingScreen.route) {
                        val viewModel: CheckingScreenViewModel = hiltViewModel()
                        val screenState =
                            viewModel.checkingScreenState.collectAsStateWithLifecycle()
                        val progressState = viewModel.progressState.collectAsStateWithLifecycle()
                        CheckingScreen(
                            navController = navHostController,
                            screenState = screenState,
                            progressState = progressState,
                            onEvent = viewModel::onEventCheckingScreen
                        )
                    }
                    composable(route = AppScreens.TransferScreen.route) {
                        val viewModel: TransferScreenViewModel = hiltViewModel()
                        val screenState =
                            viewModel.transferScreenState.collectAsStateWithLifecycle()
                        val progressState = viewModel.progressState.collectAsStateWithLifecycle()
                        TransferScreen(
                            navController = navHostController,
                            screenState = screenState,
                            progressState = progressState,
                            onEvent = viewModel::onEventTransferScreen
                        )
                    }
                }

            }
        }


    }

}

@Composable
fun rememberViewModelStoreOwner(): ViewModelStoreOwner {
    val context = LocalContext.current
    return remember(context) {
        context as ViewModelStoreOwner
    }
}

private fun getScreenTitle(appRoute: String): String {
    var title = AppConstants.EMPTY_STRING
    when (appRoute) {
        AppRouteNames.CHECKING_SCREEN -> title = ScreenTitles.TITLE_Checking
        else -> {}
    }
    return title
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun CommonAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    hideScreenTittle: Boolean
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(CustomTheme.spaces.dp56)
            .background(color = CustomTheme.colors.cardBgDefault),
    ) {
        CenterAlignedTopAppBar(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = CustomTheme.spaces.dp0),
            colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = CustomTheme.colors.cardBgDefault,
                titleContentColor = Color.Unspecified,
                actionIconContentColor = Color.Unspecified,
                navigationIconContentColor = Color.Unspecified,
                scrolledContainerColor = Color.Unspecified,
            ),
            title = {
                Row {
                    if(hideScreenTittle){
                        Text(
                            text = currentScreen,
                            color = CustomTheme.colors.text00,
                        )
                    }
                }
            },
            navigationIcon = {
                Row(
                    modifier =
                    Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                        ) {
                            if ((canNavigateBack)) {
                                navigateUp()
                            }
                        },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = AppConstants.EMPTY_STRING,
                        tint = CustomTheme.colors.action01,
                        modifier = Modifier.padding(start = CustomTheme.spaces.dp8)
                    )
                    Text(
                        "Back",
                        color = CustomTheme.colors.action01,
                        modifier = Modifier.padding(start = CustomTheme.spaces.dp8),
                        textAlign = TextAlign.Center,
                    )
                }
            },
            actions = {},
            scrollBehavior = null,
            windowInsets =
            WindowInsets(
                left = CustomTheme.spaces.dp0,
                top = CustomTheme.spaces.dp0,
                right = CustomTheme.spaces.dp0,
                bottom = CustomTheme.spaces.dp0,
            ),
        )
    }
}
val LocalNavGraphViewModelStoreOwner =
    staticCompositionLocalOf<ViewModelStoreOwner> {
        TODO("Undefined")
    }