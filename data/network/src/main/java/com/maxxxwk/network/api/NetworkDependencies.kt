package com.maxxxwk.network.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider

interface NetworkDependencies {
    val dispatchersProvider: DispatchersProvider
    val networkSettingsManager: NetworkSettingsManager
}
