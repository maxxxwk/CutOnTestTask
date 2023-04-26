package com.maxxxwk.home.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi

interface HomeScreenDependencies {
    val dispatchersProvider: DispatchersProvider
    val networkApi: NetworkApi
}
