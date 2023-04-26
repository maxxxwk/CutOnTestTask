package com.maxxxwk.catalog.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService

interface CatalogScreenDependencies {
    val dispatchersProvider: DispatchersProvider
    val apiService: ApiService
}
