package com.maxxxwk.logout.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.logout.api.LogoutScreenApi
import com.maxxxwk.logout.presentation.LogoutScreen
import com.maxxxwk.logout.presentation.LogoutScreenViewModel
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {
    @Provides
    @FeatureScope
    fun provideApi(logoutScreenViewModel: LogoutScreenViewModel): LogoutScreenApi =
        object : LogoutScreenApi {
            @Composable
            override fun Screen(onBack: () -> Unit, closeApp: () -> Unit) {
                LogoutScreen(
                    viewModel = viewModel { logoutScreenViewModel },
                    onBack = onBack,
                    closeApp = closeApp
                )
            }
        }
}
