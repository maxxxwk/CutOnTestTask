package com.maxxxwk.catalog.di

import androidx.compose.runtime.Composable
import com.maxxxwk.catalog.api.CatalogScreenApi
import com.maxxxwk.catalog.api.CatalogScreenComponentHolder
import com.maxxxwk.catalog.presentation.CatalogScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinIsolatedContext
import org.koin.dsl.module

internal val apiModule = module {
    single<CatalogScreenApi> {
        object : CatalogScreenApi {
            @Composable
            override fun Screen(bottomBar: @Composable () -> Unit) {
                KoinIsolatedContext(checkNotNull(CatalogScreenComponentHolder.koinApp)) {
                    CatalogScreen(viewModel = koinViewModel(), bottomBar = bottomBar)
                }
            }
        }
    }
}
