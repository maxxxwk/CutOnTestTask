package com.maxxxwk.network.api

import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLManager

interface NetworkApi {
    val apiService: ApiService
    val dynamicURLManager: DynamicURLManager
}
