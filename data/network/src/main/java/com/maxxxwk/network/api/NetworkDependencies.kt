package com.maxxxwk.network.api

import com.maxxxwk.kotlin.api.Dependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.auth.AuthTokenProvider

interface NetworkDependencies : Dependencies {
    val dispatchersProvider: DispatchersProvider
    val authTokenProvider: AuthTokenProvider
}
