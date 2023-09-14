package com.maxxxwk.catalog.api

import com.maxxxwk.kotlin.api.Dependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService

interface CatalogScreenDependencies : Dependencies {
    val dispatchersProvider: DispatchersProvider
    val apiService: ApiService
}
