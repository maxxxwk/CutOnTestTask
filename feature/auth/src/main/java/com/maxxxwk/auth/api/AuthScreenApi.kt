package com.maxxxwk.auth.api

import androidx.compose.runtime.Composable
import com.maxxxwk.kotlin.api.Api

interface AuthScreenApi : Api {
    @Composable
    fun Screen(navigateToHomeScreen: () -> Unit)
}
