package com.maxxxwk.testtask.di

import com.maxxxwk.testtask.screens.catalog.data.BrandCatalogRepositoryImpl
import com.maxxxwk.testtask.screens.catalog.domain.BrandCatalogRepository
import com.maxxxwk.testtask.screens.home.data.FakeMenuItemsRepositoryImpl
import com.maxxxwk.testtask.screens.home.data.MenuItemsRepositoryImpl
import com.maxxxwk.testtask.screens.home.data.UserInfoRepositoryImpl
import com.maxxxwk.testtask.screens.home.domain.MenuItemsRepository
import com.maxxxwk.testtask.screens.home.domain.UserInfoRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindMenuItemsRepository(menuItemsRepositoryImpl: MenuItemsRepositoryImpl): MenuItemsRepository

    @Binds
    @Fake
    fun bindFakeMenuItemsRepository(menuItemsRepositoryImpl: FakeMenuItemsRepositoryImpl): MenuItemsRepository

    @Binds
    fun bindUserInfoRepository(userInfoRepositoryImpl: UserInfoRepositoryImpl): UserInfoRepository

    @Binds
    fun bindBrandCatalogRepository(brandCatalogRepositoryImpl: BrandCatalogRepositoryImpl): BrandCatalogRepository
}
