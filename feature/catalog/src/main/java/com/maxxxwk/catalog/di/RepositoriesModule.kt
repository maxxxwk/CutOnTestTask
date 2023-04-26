package com.maxxxwk.catalog.di

import com.maxxxwk.catalog.data.BrandCatalogRepositoryImpl
import com.maxxxwk.catalog.domain.BrandCatalogRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoriesModule {
    @Binds
    fun bindBrandCatalogRepository(brandCatalogRepositoryImpl: BrandCatalogRepositoryImpl): BrandCatalogRepository
}
