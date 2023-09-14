package com.maxxxwk.auth.api

import com.maxxxwk.kotlin.api.Dependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.network.network.ApiService

interface AuthScreenDependencies : Dependencies {
    val dispatchersProvider: DispatchersProvider
    val apiService: ApiService
    val authTokenManager: AuthTokenManager
}
