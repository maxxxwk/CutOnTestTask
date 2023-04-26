package com.maxxxwk.testtask.di

import android.content.Context
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
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
}
