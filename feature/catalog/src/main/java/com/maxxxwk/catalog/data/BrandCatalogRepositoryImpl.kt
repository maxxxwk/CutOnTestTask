package com.maxxxwk.catalog.data

import com.maxxxwk.catalog.domain.Brand
import com.maxxxwk.catalog.domain.BrandCatalogRepository
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService
import kotlinx.coroutines.withContext

internal class BrandCatalogRepositoryImpl(
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : BrandCatalogRepository {
    override suspend fun getBrandCatalog(): Result<List<Brand>> =
        withContext(dispatchersProvider.io) {
            runCatching {
                apiService.getBrands().brands.map {
                    Brand(
                        brandId = it.value.brandId,
                        brandName = it.value.brandName,
                        brandImage = it.value.brandImage
                    )
                }
            }
        }
}
