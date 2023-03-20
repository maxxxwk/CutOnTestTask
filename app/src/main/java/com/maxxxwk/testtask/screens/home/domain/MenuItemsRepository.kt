package com.maxxxwk.testtask.screens.home.domain

interface MenuItemsRepository {
    suspend fun getMenuItems(): Result<List<MenuItem>>
}
