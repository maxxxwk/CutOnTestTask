package com.maxxxwk.logout.api

import androidx.compose.runtime.Composable

interface LogoutScreenApi {
    @Composable
    fun Screen(onBack: () -> Unit, closeApp: () -> Unit)
}
