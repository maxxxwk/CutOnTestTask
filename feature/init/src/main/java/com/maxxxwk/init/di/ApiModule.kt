package com.maxxxwk.init.di

import androidx.compose.runtime.Composable
import com.maxxxwk.init.api.InitScreenApi
import com.maxxxwk.init.api.InitScreenComponentHolder
import com.maxxxwk.init.presentation.InitScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinIsolatedContext
import org.koin.dsl.module

internal val apiModule = module {
    single<InitScreenApi> {
        object : InitScreenApi {
            @Composable
            override fun Screen(
                navigateToLoginScreen: () -> Unit,
                navigateToMainScreen: () -> Unit
            ) {
                KoinIsolatedContext(checkNotNull(InitScreenComponentHolder.koinApp)) {
                    InitScreen(
                        viewModel = koinViewModel(),
                        navigateToLoginScreen = navigateToLoginScreen,
                        navigateToMainScreen = navigateToMainScreen
                    )
                }
            }
        }
    }
}
