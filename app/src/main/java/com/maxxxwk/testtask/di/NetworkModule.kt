package com.maxxxwk.testtask.di

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.auth.AuthTokenProvider
import com.maxxxwk.network.url.DynamicURLManager
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.network.api.NetworkComponentHolder
import com.maxxxwk.network.api.NetworkDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideNetworkApi(
        dispatchersProvider: DispatchersProvider,
        authTokenManager: AuthTokenManager
    ): NetworkApi {
        NetworkComponentHolder.init(
            dependencies = object : NetworkDependencies {
                override val dispatchersProvider: DispatchersProvider = dispatchersProvider
                override val authTokenProvider: AuthTokenProvider =
                    object : AuthTokenProvider {
                        override suspend fun getAuthToken(): String = authTokenManager.getToken()
                    }
            }
        )
        return NetworkComponentHolder.getApi().also {
            NetworkComponentHolder.reset()
        }
    }

    @Provides
    fun provideApiService(networkApi: NetworkApi): ApiService = networkApi.apiService

    @Provides
    fun provideDynamicURLManager(networkApi: NetworkApi): DynamicURLManager =
        networkApi.dynamicURLManager
}
