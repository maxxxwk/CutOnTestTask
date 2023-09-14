package com.maxxxwk.home.di

import com.maxxxwk.home.data.FakeMenuItemsRepositoryImpl
import com.maxxxwk.home.data.MenuItemsRepositoryImpl
import com.maxxxwk.home.data.UserInfoRepositoryImpl
import com.maxxxwk.home.domain.MenuItemsRepository
import com.maxxxwk.home.domain.UserInfoRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val repositoriesModule = module {
    factory<MenuItemsRepository>(named("default")) { MenuItemsRepositoryImpl(get(), get()) }
    factory<MenuItemsRepository>(named("fake")) { FakeMenuItemsRepositoryImpl(get()) }
    factory<UserInfoRepository> { UserInfoRepositoryImpl(get(), get()) }
}
