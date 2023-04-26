package com.maxxxwk.init.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxxxwk.init.api.InitScreenApi
import com.maxxxwk.init.presentation.InitScreen
import com.maxxxwk.init.presentation.InitScreenViewModel
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {
    @FeatureScope
    @Provides
    fun provideApi(
        initScreenViewModel: InitScreenViewModel
    ): InitScreenApi = object : InitScreenApi {
        @Composable
        override fun Screen(
            navigateToLoginScreen: () -> Unit,
            navigateToMainScreen: () -> Unit
        ) {
            InitScreen(
                viewModel = viewModel { initScreenViewModel },
                navigateToLoginScreen = navigateToLoginScreen,
                navigateToMainScreen = navigateToMainScreen
            )
        }
    }
}
