package com.maxxxwk.testtask.screens.home.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.kotlin.result.wrapResult
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.home.domain.MenuItem
import com.maxxxwk.testtask.screens.home.domain.MenuItemsRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class MenuItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : MenuItemsRepository {
    override suspend fun getMenuItems(): Result<List<MenuItem>> = withContext(dispatchersProvider.io) {
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
