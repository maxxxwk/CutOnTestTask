package com.maxxxwk.home.api

import androidx.compose.runtime.Composable

interface HomeScreenApi {
    @Composable
    fun Screen(
        navigateToLogout: () -> Unit,
        navigateToCatalog: () -> Unit,
        bottomBar: @Composable () -> Unit
    )
}
