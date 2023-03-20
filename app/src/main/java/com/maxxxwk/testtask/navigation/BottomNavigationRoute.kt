package com.maxxxwk.testtask.navigation

import androidx.annotation.DrawableRes
import com.maxxxwk.testtask.R

enum class BottomNavigationRoute(val route: String, @DrawableRes val iconRes: Int) {
    HOME("home", R.drawable.ic_home),
    BRANDS_CATALOG("catalog", R.drawable.ic_catalog),
    COINS("coins", R.drawable.ic_coins),
    CUSTOMER_SERVICE("customer_service", R.drawable.ic_customer_service),
    SETTINGS("settings", R.drawable.ic_settings)
}
