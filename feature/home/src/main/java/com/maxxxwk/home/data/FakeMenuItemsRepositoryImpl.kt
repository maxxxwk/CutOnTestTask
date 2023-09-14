package com.maxxxwk.home.data

import com.maxxxwk.home.domain.MenuItem
import com.maxxxwk.home.domain.MenuItemsRepository
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/*
*
*   This is a fake repository implementation that simulates network request.
*   Real implementation - MenuItemsRepositoryImpl doesn't work because server returns wrong json
*
* */
internal class FakeMenuItemsRepositoryImpl(
    private val dispatchersProvider: DispatchersProvider
) : MenuItemsRepository {
    override suspend fun getMenuItems(): Result<List<MenuItem>> =
        withContext(dispatchersProvider.io) {
            delay(300L)
            Result.success(
                listOf(
                    MenuItem(
                        itemId = 1,
                        itemName = "Каталог брендів",
                        itemImage = "https://cdn.pixabay.com/photo/2014/06/03/19/38/road-sign-361514_960_720.png"
                    )
                )
            )
        }
}
