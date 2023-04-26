package com.maxxxwk.home.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxxxwk.home.api.HomeScreenApi
import com.maxxxwk.home.presentation.HomeScreen
import com.maxxxwk.home.presentation.HomeScreenViewModel
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {
    @Provides
    @FeatureScope
    fun provideApi(homeScreenViewModel: HomeScreenViewModel): HomeScreenApi =
        object : HomeScreenApi {
            @Composable
            override fun Screen(
                navigateToLogout: () -> Unit,
                navigateToCatalog: () -> Unit,
                bottomBar: @Composable () -> Unit
            ) {
                HomeScreen(
                    viewModel = viewModel { homeScreenViewModel },
                    navigateToLogout = navigateToLogout,
                    navigateToCatalog = navigateToCatalog,
                    bottomBar = bottomBar
                )
            }
        }
}
