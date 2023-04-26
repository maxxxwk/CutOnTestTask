package com.maxxxwk.home.di

import com.maxxxwk.home.data.FakeMenuItemsRepositoryImpl
import com.maxxxwk.home.data.MenuItemsRepositoryImpl
import com.maxxxwk.home.data.UserInfoRepositoryImpl
import com.maxxxwk.home.domain.MenuItemsRepository
import com.maxxxwk.home.domain.UserInfoRepository
import com.maxxxwk.kotlin.di.qualifiers.Fake
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoriesModule {
    @Binds
    fun bindMenuItemsRepository(menuItemsRepositoryImpl: MenuItemsRepositoryImpl): MenuItemsRepository

    @Binds
    @Fake
    fun bindFakeMenuItemsRepository(fakeMenuItemsRepositoryImpl: FakeMenuItemsRepositoryImpl): MenuItemsRepository

    @Binds
    fun bindUserInfoRepository(userInfoRepositoryImpl: UserInfoRepositoryImpl): UserInfoRepository
}
