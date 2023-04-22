package com.maxxxwk.testtask.di

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatchersModule {
    @Provides
    @Singleton
    fun provideDispatchersProvider(): DispatchersProvider = object : DispatchersProvider {
        override val main: CoroutineDispatcher = Dispatchers.Main
        override val io: CoroutineDispatcher = Dispatchers.IO
        override val default: CoroutineDispatcher = Dispatchers.Default
        override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
    }
}
