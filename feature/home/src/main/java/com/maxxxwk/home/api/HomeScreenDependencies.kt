package com.maxxxwk.home.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService

interface HomeScreenDependencies {
    val dispatchersProvider: DispatchersProvider
    val apiService: ApiService
}
