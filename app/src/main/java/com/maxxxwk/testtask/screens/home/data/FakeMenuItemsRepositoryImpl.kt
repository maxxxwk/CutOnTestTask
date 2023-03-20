package com.maxxxwk.testtask.screens.home.data

import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.screens.home.domain.MenuItem
import com.maxxxwk.testtask.screens.home.domain.MenuItemsRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/*
*
*   This is a fake repository implementation that simulates network request.
*   Real implementation - MenuItemsRepositoryImpl doesn't work because server returns wrong json
*
* */
class FakeMenuItemsRepositoryImpl @Inject constructor(
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : MenuItemsRepository {
    override suspend fun getMenuItems(): Result<List<MenuItem>> = withContext(dispatcher) {
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
