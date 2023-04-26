package com.maxxxwk.auth.api

import androidx.compose.runtime.Composable

interface AuthScreenApi {
    @Composable
    fun Screen(navigateToHomeScreen: () -> Unit)
}
