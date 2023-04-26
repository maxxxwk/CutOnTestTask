package com.maxxxwk.testtask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController

class BottomNavigationController(
    private val navController: NavController,
    private val componentsInitializer: (BottomNavigationRoute) -> Unit
) {
    fun navigateToHome() {
        navigateTo(BottomNavigationRoute.HOME)
    }

    fun navigateToBrandsCatalog() {
        navigateTo(BottomNavigationRoute.BRANDS_CATALOG)
    }

    fun navigateToCoins() {
        navigateTo(BottomNavigationRoute.COINS)
    }

    fun navigateToCustomerService() {
        navigateTo(BottomNavigationRoute.CUSTOMER_SERVICE)
    }

    fun navigateToSettings() {
        navigateTo(BottomNavigationRoute.SETTINGS)
    }

    private fun navigateTo(bottomNavigationRoute: BottomNavigationRoute) {
        componentsInitializer(bottomNavigationRoute)
        navController.navigate(bottomNavigationRoute.route) {
            popUpTo(BottomNavigationRoute.HOME.route) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberBottomNavigationController(
    navController: NavController,
    componentsInitializer: (BottomNavigationRoute) -> Unit
) = remember { BottomNavigationController(navController, componentsInitializer) }
