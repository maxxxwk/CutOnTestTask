package com.maxxxwk.init.di

import com.maxxxwk.init.data.InitRepositoryImpl
import com.maxxxwk.init.data.NetworkStateRepositoryImpl
import com.maxxxwk.init.domain.InitRepository
import com.maxxxwk.init.domain.NetworkStateRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal val repositoriesModule = module {
    factory<InitRepository> { InitRepositoryImpl(get(), get(), get()) }
    factory<NetworkStateRepository> { NetworkStateRepositoryImpl(androidContext()) }
}
