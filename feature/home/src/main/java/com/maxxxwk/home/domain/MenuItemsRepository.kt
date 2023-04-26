package com.maxxxwk.home.domain

import com.maxxxwk.home.domain.MenuItem

internal interface MenuItemsRepository {
    suspend fun getMenuItems(): Result<List<MenuItem>>
}
