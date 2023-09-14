package com.maxxxwk.logout.di

import androidx.compose.runtime.Composable
import com.maxxxwk.logout.api.LogoutScreenApi
import com.maxxxwk.logout.api.LogoutScreenComponentHolder
import com.maxxxwk.logout.presentation.LogoutScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinIsolatedContext
import org.koin.dsl.module

internal val apiModule = module {
    single<LogoutScreenApi> {
        object : LogoutScreenApi {
            @Composable
            override fun Screen(onBack: () -> Unit, closeApp: () -> Unit) {
                KoinIsolatedContext(checkNotNull(LogoutScreenComponentHolder.koinApp)) {
                    LogoutScreen(
                        viewModel = koinViewModel(),
                        onBack = onBack,
                        closeApp = closeApp
                    )
                }
            }
        }
    }
}
