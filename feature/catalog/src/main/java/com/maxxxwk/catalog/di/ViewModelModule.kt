package com.maxxxwk.catalog.di

import com.maxxxwk.catalog.presentation.CatalogScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModelOf(::CatalogScreenViewModel)
}
