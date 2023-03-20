package com.maxxxwk.testtask.screens.home.data

import com.maxxxwk.testtask.common.result.wrapResult
import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.home.domain.MenuItem
import com.maxxxwk.testtask.screens.home.domain.MenuItemsRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MenuItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : MenuItemsRepository {
    override suspend fun getMenuItems(): Result<List<MenuItem>> = withContext(dispatcher) {
        wrapResult {
            apiService.getMenuItems().let { response ->
                response.items.map {
                    MenuItem(
                        itemId = it.itemId,
                        itemImage = it.itemImage,
                        itemName = it.itemName
                    )
                }
            }
        }
    }
}
