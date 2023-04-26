package com.maxxxwk.home.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.home.domain.MenuItem
import com.maxxxwk.home.domain.MenuItemsRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class MenuItemsRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
    private val dispatchersProvider: DispatchersProvider
) : MenuItemsRepository {
    override suspend fun getMenuItems(): Result<List<MenuItem>> =
        withContext(dispatchersProvider.io) {
            runCatching {
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
