package com.maxxxwk.network.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.auth.AuthTokenProvider

interface NetworkDependencies {
    val dispatchersProvider: DispatchersProvider
    val authTokenProvider: AuthTokenProvider
}
