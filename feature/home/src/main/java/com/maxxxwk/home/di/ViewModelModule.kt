package com.maxxxwk.home.di

import com.maxxxwk.home.presentation.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModel { HomeScreenViewModel(get(), get(named("fake"))) }
}
