package com.maxxxwk.testtask.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.maxxxwk.testtask.screens.auth.presentation.AuthScreen
import com.maxxxwk.testtask.screens.catalog.presentation.CatalogScreen
import com.maxxxwk.testtask.screens.home.presentation.HomeScreen
import com.maxxxwk.testtask.screens.init.presentation.InitScreen
import com.maxxxwk.testtask.screens.logout.presentation.LogoutScreen
import com.maxxxwk.testtask.ui.components.BottomNavigationBar


@Suppress("FunctionNaming")
@Composable
fun Navigation(
    startDestination: String,
    viewModelFactory: ViewModelProvider.Factory,
    closeApp: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationRoute.INIT.route) {
            InitScreen(
                viewModel = viewModel(factory = viewModelFactory),
                navigateToLoginScreen = {
                    navController.popBackStack()
                    navController.navigate(NavigationRoute.LOGIN.route)
                }
            )
        }
        composable(NavigationRoute.LOGIN.route) {
            AuthScreen(
                viewModel = viewModel(factory = viewModelFactory),
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
                HomeScreen(
                    viewModel = viewModel(factory = viewModelFactory),
                    navigateToLogout = { navController.navigate(NavigationRoute.LOGOUT.route) },
                    navigateToCatalog = {
                        navController.navigate(BottomNavigationRoute.BRANDS_CATALOG)
                    },
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
            LogoutScreen(
                viewModel = viewModel(factory = viewModelFactory),
                onBack = { navController.popBackStack() },
                closeApp = closeApp
            )
        }
    }
}
