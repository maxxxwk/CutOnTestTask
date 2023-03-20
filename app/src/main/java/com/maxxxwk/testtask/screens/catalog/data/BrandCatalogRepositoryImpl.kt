package com.maxxxwk.testtask.screens.catalog.data

import com.maxxxwk.testtask.common.result.wrapResult
import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.catalog.domain.Brand
import com.maxxxwk.testtask.screens.catalog.domain.BrandCatalogRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BrandCatalogRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : BrandCatalogRepository {
    override suspend fun getBrandCatalog(): Result<List<Brand>> = withContext(dispatcher) {
        wrapResult {
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
