package com.maxxxwk.catalog.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxxxwk.catalog.api.CatalogScreenApi
import com.maxxxwk.catalog.presentation.CatalogScreen
import com.maxxxwk.catalog.presentation.CatalogScreenViewModel
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {
    @Provides
    @FeatureScope
    fun provideApi(catalogScreenViewModel: CatalogScreenViewModel): CatalogScreenApi =
        object : CatalogScreenApi {
            @Composable
            override fun Screen(bottomBar: @Composable () -> Unit) {
                CatalogScreen(
                    viewModel = viewModel { catalogScreenViewModel },
                    bottomBar = bottomBar
                )
            }
        }
}
