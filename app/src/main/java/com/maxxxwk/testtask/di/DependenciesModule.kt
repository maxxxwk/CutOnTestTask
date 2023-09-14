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
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dependenciesModule = module {
    factory<InitScreenDependencies> {
        object : InitScreenDependencies {
            override val context: Context = androidContext()
            override val dispatchersProvider: DispatchersProvider = get()
            override val apiService: ApiService = get()
            override val authTokenManager: AuthTokenManager = get()
            override val dynamicURLManager: DynamicURLManager = get()
        }
    }
    factory<AuthScreenDependencies> {
        object : AuthScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = get()
            override val apiService: ApiService = get()
            override val authTokenManager: AuthTokenManager = get()
        }
    }
    factory<LogoutScreenDependencies> {
        object : LogoutScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = get()
            override val apiService: ApiService = get()
            override val authTokenManager: AuthTokenManager = get()
        }
    }
    factory<HomeScreenDependencies> {
        object : HomeScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = get()
            override val apiService: ApiService = get()
        }
    }
    factory<CatalogScreenDependencies> {
        object : CatalogScreenDependencies {
            override val dispatchersProvider: DispatchersProvider = get()
            override val apiService: ApiService = get()
        }
    }
}
