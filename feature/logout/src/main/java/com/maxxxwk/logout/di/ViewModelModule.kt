package com.maxxxwk.logout.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.maxxxwk.logout.presentation.LogoutScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf

internal val viewModelModule = module {
    viewModelOf(::LogoutScreenViewModel)
}
