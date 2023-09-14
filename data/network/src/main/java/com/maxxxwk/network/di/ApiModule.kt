package com.maxxxwk.network.di

import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLManager
import org.koin.dsl.module

internal val apiModule = module {
    single<NetworkApi> {
        object : NetworkApi {
            override val apiService: ApiService = get()
            override val dynamicURLManager: DynamicURLManager = get()
        }
    }
}
