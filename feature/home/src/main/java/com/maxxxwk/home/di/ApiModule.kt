package com.maxxxwk.home.di

import androidx.compose.runtime.Composable
import com.maxxxwk.home.api.HomeScreenApi
import com.maxxxwk.home.api.HomeScreenComponentHolder
import com.maxxxwk.home.presentation.HomeScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinIsolatedContext
import org.koin.dsl.module

internal val apiModule = module {
    single<HomeScreenApi> {
        object : HomeScreenApi {
            @Composable
            override fun Screen(
                navigateToLogout: () -> Unit,
                navigateToCatalog: () -> Unit,
                bottomBar: @Composable () -> Unit
            ) {
                KoinIsolatedContext(checkNotNull(HomeScreenComponentHolder.koinApp)) {
                    HomeScreen(
                        viewModel = koinViewModel(),
                        navigateToLogout = navigateToLogout,
                        navigateToCatalog = navigateToCatalog,
                        bottomBar = bottomBar
                    )
                }
            }
        }
    }
}
