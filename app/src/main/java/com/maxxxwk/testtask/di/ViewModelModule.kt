package com.maxxxwk.testtask.di

import androidx.lifecycle.ViewModel
import com.maxxxwk.android.viewmodel.ViewModelKey
import com.maxxxwk.testtask.screens.auth.presentation.AuthScreenViewModel
import com.maxxxwk.testtask.screens.catalog.presentation.CatalogScreenViewModel
import com.maxxxwk.testtask.screens.home.presentation.HomeScreenViewModel
import com.maxxxwk.testtask.screens.logout.presentation.LogoutScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(AuthScreenViewModel::class)]
    fun bindAuthScreenViewModel(viewModel: AuthScreenViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(LogoutScreenViewModel::class)]
    fun bindLogoutScreenViewModel(viewModel: LogoutScreenViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(HomeScreenViewModel::class)]
    fun bindHomeScreenViewModel(viewModel: HomeScreenViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CatalogScreenViewModel::class)]
    fun bindCatalogScreenViewModel(viewModel: CatalogScreenViewModel): ViewModel
}
