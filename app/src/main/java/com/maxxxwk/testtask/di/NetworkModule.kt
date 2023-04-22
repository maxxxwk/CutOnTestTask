package com.maxxxwk.testtask.di

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.network.api.NetworkComponentHolder
import com.maxxxwk.network.api.NetworkDependencies
import com.maxxxwk.network.api.NetworkSettingsManager
import com.maxxxwk.testtask.network.auth.AuthTokenManager
import com.maxxxwk.testtask.network.url.DynamicURLManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(
        dispatchersProvider: DispatchersProvider,
        authTokenManager: AuthTokenManager,
        dynamicURLManager: DynamicURLManager
    ): NetworkApi {
        NetworkComponentHolder.init(
            dependencies = object : NetworkDependencies {
                override val dispatchersProvider: DispatchersProvider = dispatchersProvider
                override val networkSettingsManager: NetworkSettingsManager = object : NetworkSettingsManager {
                    override fun getDynamicURL(): String = dynamicURLManager.getURL()
                    override fun getAuthToken(): String = authTokenManager.getToken()
                }
            }
        )
        return NetworkComponentHolder.getApi()
    }
}
