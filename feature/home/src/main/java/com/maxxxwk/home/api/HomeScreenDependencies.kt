package com.maxxxwk.home.api

import com.maxxxwk.kotlin.api.Dependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService

interface HomeScreenDependencies : Dependencies {
    val dispatchersProvider: DispatchersProvider
    val apiService: ApiService
}
