package com.maxxxwk.testtask.di

import androidx.lifecycle.ViewModel
import com.maxxxwk.android.viewmodel.ViewModelKey
import com.maxxxwk.testtask.screens.catalog.presentation.CatalogScreenViewModel
import com.maxxxwk.testtask.screens.home.presentation.HomeScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(HomeScreenViewModel::class)]
    fun bindHomeScreenViewModel(viewModel: HomeScreenViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CatalogScreenViewModel::class)]
    fun bindCatalogScreenViewModel(viewModel: CatalogScreenViewModel): ViewModel
}
