package com.maxxxwk.init.api

import android.content.Context
import com.maxxxwk.init.data.DynamicURLManager
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.network.api.NetworkApi

interface InitScreenDependencies {
    val context: Context
    val dispatchersProvider: DispatchersProvider
    val networkApi: NetworkApi
    val authTokenManager: AuthTokenManager
    val dynamicURLManager: DynamicURLManager
}
