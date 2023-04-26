package com.maxxxwk.catalog.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi

interface CatalogScreenDependencies {
    val dispatchersProvider: DispatchersProvider
    val networkApi: NetworkApi
}
