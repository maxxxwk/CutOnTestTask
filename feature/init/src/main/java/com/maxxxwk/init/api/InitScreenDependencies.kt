package com.maxxxwk.init.api

import android.content.Context
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLManager

interface InitScreenDependencies {
    val context: Context
    val dispatchersProvider: DispatchersProvider
    val apiService: ApiService
    val authTokenManager: AuthTokenManager
    val dynamicURLManager: DynamicURLManager
}
