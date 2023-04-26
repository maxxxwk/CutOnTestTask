package com.maxxxwk.network.di

import com.maxxxwk.network.url.DynamicURLManager
import com.maxxxwk.network.url.DynamicURLManagerImpl
import dagger.Binds
import dagger.Module

@Module
internal interface BindsModule {
    @Binds
    fun bindDynamicURLManager(dynamicURLManagerImpl: DynamicURLManagerImpl): DynamicURLManager
}
