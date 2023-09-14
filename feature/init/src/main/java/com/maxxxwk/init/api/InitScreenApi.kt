package com.maxxxwk.init.api

import androidx.compose.runtime.Composable
import com.maxxxwk.kotlin.api.Api

interface InitScreenApi : Api {
    @Composable
    fun Screen(
        navigateToLoginScreen: () -> Unit,
        navigateToMainScreen: () -> Unit
    )
}
