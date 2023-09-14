package com.maxxxwk.logout.api

import androidx.compose.runtime.Composable
import com.maxxxwk.kotlin.api.Api

interface LogoutScreenApi: Api {
    @Composable
    fun Screen(onBack: () -> Unit, closeApp: () -> Unit)
}
