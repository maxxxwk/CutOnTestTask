package com.maxxxwk.testtask.network.url

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DynamicURLManager @Inject constructor() {
    var url: String? = null

    fun getURL(): String {
        checkNotNull(url) { "Token is missing!" }
        return url!!
    }
}
