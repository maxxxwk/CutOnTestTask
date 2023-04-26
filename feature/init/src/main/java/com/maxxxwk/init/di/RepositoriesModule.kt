package com.maxxxwk.init.di

import com.maxxxwk.init.data.InitRepositoryImpl
import com.maxxxwk.init.data.NetworkStateRepositoryImpl
import com.maxxxwk.init.domain.InitRepository
import com.maxxxwk.init.domain.NetworkStateRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoriesModule {
    @Binds
    fun bindInitRepository(initRepositoryImpl: InitRepositoryImpl): InitRepository
    @Binds
    fun bindNetworkStateRepository(networkStateRepositoryImpl: NetworkStateRepositoryImpl): NetworkStateRepository
}
