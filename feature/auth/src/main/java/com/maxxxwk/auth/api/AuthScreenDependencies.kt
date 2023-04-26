package com.maxxxwk.auth.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.network.api.NetworkApi

interface AuthScreenDependencies {
    val dispatchersProvider: DispatchersProvider
    val networkApi: NetworkApi
    val authTokenManager: AuthTokenManager
}
