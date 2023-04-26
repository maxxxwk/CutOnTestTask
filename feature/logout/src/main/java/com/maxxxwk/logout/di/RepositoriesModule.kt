package com.maxxxwk.logout.di

import com.maxxxwk.logout.data.LogoutRepositoryImpl
import com.maxxxwk.logout.domain.LogoutRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoriesModule {
    @Binds
    fun bindLogoutRepository(logoutRepositoryImpl: LogoutRepositoryImpl): LogoutRepository
}
