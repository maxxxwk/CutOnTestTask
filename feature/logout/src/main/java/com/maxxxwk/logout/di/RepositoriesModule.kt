package com.maxxxwk.logout.di

import com.maxxxwk.logout.data.LogoutRepositoryImpl
import com.maxxxwk.logout.domain.LogoutRepository
import org.koin.dsl.module

internal val repositoriesModule = module {
    factory<LogoutRepository> { LogoutRepositoryImpl(get(), get(), get()) }
}
