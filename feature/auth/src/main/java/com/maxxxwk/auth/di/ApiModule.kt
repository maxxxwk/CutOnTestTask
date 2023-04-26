package com.maxxxwk.auth.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxxxwk.auth.api.AuthScreenApi
import com.maxxxwk.auth.presentation.AuthScreen
import com.maxxxwk.auth.presentation.AuthScreenViewModel
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {
    @FeatureScope
    @Provides
    fun provideApi(authScreenViewModel: AuthScreenViewModel): AuthScreenApi =
        object : AuthScreenApi {
            @Composable
            override fun Screen(navigateToHomeScreen: () -> Unit) {
                AuthScreen(
                    viewModel = viewModel { authScreenViewModel },
                    navigateToHomeScreen = navigateToHomeScreen
                )
            }
        }
}
