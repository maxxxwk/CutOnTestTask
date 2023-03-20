package com.maxxxwk.testtask.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatchersModule {
    @[Provides DispatcherMain]
    fun provideDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

    @[Provides DispatcherIO]
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @[Provides DispatcherDefault]
    fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @[Provides DispatcherUnconfined]
    fun provideDispatcherUnconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
