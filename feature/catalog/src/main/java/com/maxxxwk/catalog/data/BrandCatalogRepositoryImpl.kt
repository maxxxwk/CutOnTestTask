package com.maxxxwk.catalog.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.catalog.domain.Brand
import com.maxxxwk.catalog.domain.BrandCatalogRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class BrandCatalogRepositoryImpl @Inject constructor(
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
