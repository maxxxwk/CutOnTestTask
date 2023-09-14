package com.maxxxwk.home.api

import androidx.compose.runtime.Composable
import com.maxxxwk.kotlin.api.Api

interface HomeScreenApi : Api {
    @Composable
    fun Screen(
        navigateToLogout: () -> Unit,
        navigateToCatalog: () -> Unit,
        bottomBar: @Composable () -> Unit
    )
}
