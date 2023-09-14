package com.maxxxwk.network.api

import com.maxxxwk.kotlin.api.Api
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLManager

interface NetworkApi : Api {
    val apiService: ApiService
    val dynamicURLManager: DynamicURLManager
}
