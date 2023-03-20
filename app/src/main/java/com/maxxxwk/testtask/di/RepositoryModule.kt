package com.maxxxwk.testtask.di

import com.maxxxwk.testtask.screens.auth.data.AppInfoRepositoryImpl
import com.maxxxwk.testtask.screens.auth.data.AuthRepositoryImpl
import com.maxxxwk.testtask.screens.auth.data.DeviceInfoRepositoryImpl
import com.maxxxwk.testtask.screens.auth.domain.AppInfoRepository
import com.maxxxwk.testtask.screens.auth.domain.AuthRepository
import com.maxxxwk.testtask.screens.auth.domain.DeviceInfoRepository
import com.maxxxwk.testtask.screens.catalog.data.BrandCatalogRepositoryImpl
import com.maxxxwk.testtask.screens.catalog.domain.BrandCatalogRepository
import com.maxxxwk.testtask.screens.home.data.FakeMenuItemsRepositoryImpl
import com.maxxxwk.testtask.screens.home.data.MenuItemsRepositoryImpl
import com.maxxxwk.testtask.screens.home.data.UserInfoRepositoryImpl
import com.maxxxwk.testtask.screens.home.domain.MenuItemsRepository
import com.maxxxwk.testtask.screens.home.domain.UserInfoRepository
import com.maxxxwk.testtask.screens.init.data.InitRepositoryImpl
import com.maxxxwk.testtask.screens.init.data.NetworkStateRepositoryImpl
import com.maxxxwk.testtask.screens.init.domain.InitRepository
import com.maxxxwk.testtask.screens.init.domain.NetworkStateRepository
import com.maxxxwk.testtask.screens.logout.data.LogoutRepositoryImpl
import com.maxxxwk.testtask.screens.logout.domain.LogoutRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindInitRepository(initRepositoryImpl: InitRepositoryImpl): InitRepository

    @Binds
    fun bindNetworkStateRepository(networkStateRepositoryImpl: NetworkStateRepositoryImpl): NetworkStateRepository

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindDeviceInfoRepository(deviceInfoRepositoryImpl: DeviceInfoRepositoryImpl): DeviceInfoRepository

    @Binds
    fun bindAppInfoRepository(appInfoRepositoryImpl: AppInfoRepositoryImpl): AppInfoRepository

    @Binds
    fun bindLogoutRepository(logoutRepositoryImpl: LogoutRepositoryImpl): LogoutRepository

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
