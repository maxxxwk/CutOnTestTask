package com.maxxxwk.auth.di

import com.maxxxwk.auth.presentation.AuthScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModelOf(::AuthScreenViewModel)
}
