package com.maxxxwk.init.api

import androidx.compose.runtime.Composable

interface InitScreenApi {
    @Composable
    fun Screen(
        navigateToLoginScreen: () -> Unit,
        navigateToMainScreen: () -> Unit
    )
}
