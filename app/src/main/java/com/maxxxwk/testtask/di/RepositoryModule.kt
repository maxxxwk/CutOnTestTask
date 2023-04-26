package com.maxxxwk.testtask.di

import com.maxxxwk.testtask.screens.catalog.data.BrandCatalogRepositoryImpl
import com.maxxxwk.testtask.screens.catalog.domain.BrandCatalogRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindBrandCatalogRepository(brandCatalogRepositoryImpl: BrandCatalogRepositoryImpl): BrandCatalogRepository
}
