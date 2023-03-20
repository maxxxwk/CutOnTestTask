package com.maxxxwk.testtask.navigation

import androidx.navigation.NavController

fun NavController.navigate(bottomNavigationRoute: BottomNavigationRoute) {
    navigate(bottomNavigationRoute.route) {
        popUpTo(BottomNavigationRoute.HOME.route) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
