package com.maxxxwk.catalog.domain

import com.maxxxwk.catalog.domain.Brand

internal interface BrandCatalogRepository {
    suspend fun getBrandCatalog(): Result<List<Brand>>
}
