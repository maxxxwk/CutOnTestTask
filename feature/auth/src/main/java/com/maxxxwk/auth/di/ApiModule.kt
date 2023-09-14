package com.maxxxwk.auth.di

import androidx.compose.runtime.Composable
import com.maxxxwk.auth.api.AuthScreenApi
import com.maxxxwk.auth.api.AuthScreenComponentHolder
import com.maxxxwk.auth.presentation.AuthScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinIsolatedContext
import org.koin.dsl.module

internal val apiModule = module {
    single<AuthScreenApi> {
        object : AuthScreenApi {
            @Composable
            override fun Screen(navigateToHomeScreen: () -> Unit) {
                KoinIsolatedContext(checkNotNull(AuthScreenComponentHolder.koinApp)) {
                    AuthScreen(
                        viewModel = koinViewModel(),
                        navigateToHomeScreen = navigateToHomeScreen
                    )
                }
            }
        }
    }
}
