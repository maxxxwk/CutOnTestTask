package com.maxxxwk.testtask.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.maxxxwk.auth.api.AuthScreenComponentHolder
import com.maxxxwk.home.api.HomeScreenComponentHolder
import com.maxxxwk.init.api.InitScreenComponentHolder
import com.maxxxwk.logout.api.LogoutScreenComponentHolder
import com.maxxxwk.testtask.screens.catalog.presentation.CatalogScreen
import com.maxxxwk.testtask.ui.components.BottomNavigationBar


@Suppress("FunctionNaming")
@Composable
fun Navigation(
    viewModelFactory: ViewModelProvider.Factory,
    closeApp: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.INIT.route
    ) {
        composable(NavigationRoute.INIT.route) {
            InitScreenComponentHolder.getApi().Screen(
                navigateToLoginScreen = {
                    navController.popBackStack()
                    navController.navigate(NavigationRoute.LOGIN.route)
                },
                navigateToMainScreen = {
                    navController.popBackStack()
                    navController.navigate(NavigationRoute.MAIN.route)
                }
            )
        }
        composable(NavigationRoute.LOGIN.route) {
            AuthScreenComponentHolder.getApi().Screen(
                navigateToHomeScreen = {
                    navController.popBackStack()
                    navController.navigate(NavigationRoute.MAIN.route)
                }
            )
        }
        navigation(
            route = NavigationRoute.MAIN.route,
            startDestination = BottomNavigationRoute.HOME.route
        ) {
            composable(BottomNavigationRoute.HOME.route) {
                HomeScreenComponentHolder.getApi().Screen(
                    navigateToLogout = { navController.navigate(NavigationRoute.LOGOUT.route) },
                    navigateToCatalog = { navController.navigate(BottomNavigationRoute.BRANDS_CATALOG) },
                    bottomBar = { BottomNavigationBar(navController = navController) }
                )
            }
            composable(BottomNavigationRoute.BRANDS_CATALOG.route) {
                CatalogScreen(
                    viewModel = viewModel(factory = viewModelFactory),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                )
            }
            composable(BottomNavigationRoute.COINS.route) {}
            composable(BottomNavigationRoute.CUSTOMER_SERVICE.route) {}
            composable(BottomNavigationRoute.SETTINGS.route) {}
        }
        composable(NavigationRoute.LOGOUT.route) {
            LogoutScreenComponentHolder.getApi().Screen(
                onBack = navController::popBackStack,
                closeApp = closeApp
            )
        }
    }
}
