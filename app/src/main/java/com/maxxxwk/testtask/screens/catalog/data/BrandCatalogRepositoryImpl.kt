package com.maxxxwk.testtask.screens.catalog.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.screens.catalog.domain.Brand
import com.maxxxwk.testtask.screens.catalog.domain.BrandCatalogRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class BrandCatalogRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
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
