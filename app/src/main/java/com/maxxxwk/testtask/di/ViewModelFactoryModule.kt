package com.maxxxwk.testtask.di

import androidx.lifecycle.ViewModelProvider
import com.maxxxwk.android.viewmodel.ViewModelFactory
import com.maxxxwk.android.viewmodel.ViewModelsProviders
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {
    @Singleton
    @Provides
    fun provideViewModelFactory(viewModelProviders: ViewModelsProviders): ViewModelProvider.Factory {
        return ViewModelFactory(viewModelProviders)
    }
}
