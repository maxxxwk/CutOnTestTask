package com.maxxxwk.catalog.di

import com.maxxxwk.catalog.data.BrandCatalogRepositoryImpl
import com.maxxxwk.catalog.domain.BrandCatalogRepository
import org.koin.dsl.module

internal val repositoriesModule = module {
    factory<BrandCatalogRepository> { BrandCatalogRepositoryImpl(get(), get()) }
}
