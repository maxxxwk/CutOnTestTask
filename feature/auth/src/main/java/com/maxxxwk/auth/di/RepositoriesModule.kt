package com.maxxxwk.auth.di

import com.maxxxwk.auth.data.AppInfoRepositoryImpl
import com.maxxxwk.auth.data.AuthRepositoryImpl
import com.maxxxwk.auth.data.DeviceInfoRepositoryImpl
import com.maxxxwk.auth.domain.AppInfoRepository
import com.maxxxwk.auth.domain.AuthRepository
import com.maxxxwk.auth.domain.DeviceInfoRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val repositoriesModule = module {
    factory<AppInfoRepository> { AppInfoRepositoryImpl(get(), get()) }
    factory<AuthRepository> { AuthRepositoryImpl(get(), get(), get()) }
    factoryOf<DeviceInfoRepository>(::DeviceInfoRepositoryImpl)
}
