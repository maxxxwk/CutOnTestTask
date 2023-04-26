package com.maxxxwk.testtask.di

import android.content.Context
import com.maxxxwk.auth.api.AuthScreenDependencies
import com.maxxxwk.catalog.api.CatalogScreenDependencies
import com.maxxxwk.home.api.HomeScreenDependencies
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.logout.api.LogoutScreenDependencies
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.network.url.DynamicURLManager
import dagger.Module
import dagger.Provides

@Module
class DependenciesModule {
    @Provides
    fun provideInitScreenDependencies(
        context: Context,
        dispatchersProvider: DispatchersProvider,
        networkApi: NetworkApi,
        authTokenManager: AuthTokenManager,
        dynamicURLManager: DynamicURLManager
    ): InitScreenDependencies {
        return object : InitScreenDependencies {
            override val context: Context = context
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val networkApi: NetworkApi = networkApi
            override val authTokenManager: AuthTokenManager = authTokenManager
            override val dynamicURLManager: com.maxxxwk.init.data.DynamicURLManager =
                object : com.maxxxwk.init.data.DynamicURLManager {
                    override fun saveURL(url: String) {
                        dynamicURLManager.url = url
                    }
                }
        }
    }

    @Provides
    fun provideAuthScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        networkApi: NetworkApi,
        authTokenManager: AuthTokenManager
    ): AuthScreenDependencies {
        return object : AuthScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val networkApi: NetworkApi = networkApi
            override val authTokenManager: AuthTokenManager = authTokenManager
        }
    }

    @Provides
    fun provideLogoutScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        networkApi: NetworkApi,
        authTokenManager: AuthTokenManager
    ): LogoutScreenDependencies {
        return object : LogoutScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val networkApi: NetworkApi = networkApi
            override val authTokenManager: AuthTokenManager = authTokenManager
        }
    }

    @Provides
    fun provideHomeScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        networkApi: NetworkApi
    ): HomeScreenDependencies {
        return object : HomeScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val networkApi: NetworkApi = networkApi
        }
    }

    @Provides
    fun provideCatalogScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        networkApi: NetworkApi
    ): CatalogScreenDependencies {
        return object : CatalogScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val networkApi: NetworkApi = networkApi
        }
    }
}
