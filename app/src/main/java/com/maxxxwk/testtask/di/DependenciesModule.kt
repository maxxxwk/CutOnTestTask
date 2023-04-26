package com.maxxxwk.testtask.di

import android.content.Context
import com.maxxxwk.auth.api.AuthScreenDependencies
import com.maxxxwk.catalog.api.CatalogScreenDependencies
import com.maxxxwk.home.api.HomeScreenDependencies
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.logout.api.LogoutScreenDependencies
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLManager
import dagger.Module
import dagger.Provides

@Module
class DependenciesModule {
    @Provides
    fun provideInitScreenDependencies(
        context: Context,
        dispatchersProvider: DispatchersProvider,
        apiService: ApiService,
        authTokenManager: AuthTokenManager,
        dynamicURLManager: DynamicURLManager
    ): InitScreenDependencies {
        return object : InitScreenDependencies {
            override val context: Context = context
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val apiService: ApiService = apiService
            override val authTokenManager: AuthTokenManager = authTokenManager
            override val dynamicURLManager: DynamicURLManager = dynamicURLManager
        }
    }

    @Provides
    fun provideAuthScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        apiService: ApiService,
        authTokenManager: AuthTokenManager
    ): AuthScreenDependencies {
        return object : AuthScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val apiService: ApiService = apiService
            override val authTokenManager: AuthTokenManager = authTokenManager
        }
    }

    @Provides
    fun provideLogoutScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        apiService: ApiService,
        authTokenManager: AuthTokenManager
    ): LogoutScreenDependencies {
        return object : LogoutScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val apiService: ApiService = apiService
            override val authTokenManager: AuthTokenManager = authTokenManager
        }
    }

    @Provides
    fun provideHomeScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        apiService: ApiService
    ): HomeScreenDependencies {
        return object : HomeScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val apiService: ApiService = apiService
        }
    }

    @Provides
    fun provideCatalogScreenDependencies(
        dispatchersProvider: DispatchersProvider,
        apiService: ApiService
    ): CatalogScreenDependencies {
        return object : CatalogScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = dispatchersProvider
            override val apiService: ApiService = apiService
        }
    }
}
