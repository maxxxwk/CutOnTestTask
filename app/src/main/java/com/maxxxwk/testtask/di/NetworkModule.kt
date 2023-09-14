package com.maxxxwk.testtask.di

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.network.api.NetworkComponentHolder
import com.maxxxwk.network.api.NetworkDependencies
import com.maxxxwk.network.auth.AuthTokenProvider
import org.koin.dsl.module

val networkModule = module {
    single {
        NetworkComponentHolder.init(
            dependencies = object : NetworkDependencies {
                override val dispatchersProvider: DispatchersProvider = get()
                override val authTokenProvider: AuthTokenProvider = object : AuthTokenProvider {
                    override suspend fun getAuthToken(): String = get<AuthTokenManager>().getToken()
                }
            }
        )
        NetworkComponentHolder.getApi().also {
            NetworkComponentHolder.reset()
        }
    }
    factory { get<NetworkApi>().apiService }
    factory { get<NetworkApi>().dynamicURLManager }
}
