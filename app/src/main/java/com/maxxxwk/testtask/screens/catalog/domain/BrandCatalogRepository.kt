package com.maxxxwk.testtask.screens.catalog.domain

interface BrandCatalogRepository {
    suspend fun getBrandCatalog(): Result<List<Brand>>
}
