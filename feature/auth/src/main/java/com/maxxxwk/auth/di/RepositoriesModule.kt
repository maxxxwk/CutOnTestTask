package com.maxxxwk.auth.di

import com.maxxxwk.auth.data.AppInfoRepositoryImpl
import com.maxxxwk.auth.data.AuthRepositoryImpl
import com.maxxxwk.auth.data.DeviceInfoRepositoryImpl
import com.maxxxwk.auth.domain.AppInfoRepository
import com.maxxxwk.auth.domain.AuthRepository
import com.maxxxwk.auth.domain.DeviceInfoRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoriesModule {
    @Binds
    fun bindAppInfoRepository(appInfoRepositoryImpl: AppInfoRepositoryImpl): AppInfoRepository

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindDeviceInfoRepository(deviceInfoRepositoryImpl: DeviceInfoRepositoryImpl): DeviceInfoRepository
}
