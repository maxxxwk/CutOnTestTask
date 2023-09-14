package com.maxxxwk.init.di

import com.maxxxwk.init.presentation.InitScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModelOf(::InitScreenViewModel)
}
