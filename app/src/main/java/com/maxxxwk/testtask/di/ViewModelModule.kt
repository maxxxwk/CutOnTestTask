package com.maxxxwk.testtask.di

import androidx.lifecycle.ViewModel
import com.maxxxwk.android.viewmodel.ViewModelKey
import com.maxxxwk.testtask.screens.catalog.presentation.CatalogScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(CatalogScreenViewModel::class)]
    fun bindCatalogScreenViewModel(viewModel: CatalogScreenViewModel): ViewModel
}
