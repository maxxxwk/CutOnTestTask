package com.maxxxwk.logout.api

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.network.api.NetworkApi

interface LogoutScreenDependencies {
    val dispatchersProvider: DispatchersProvider
    val networkApi: NetworkApi
    val authTokenManager: AuthTokenManager
}
