package com.maxxxwk.testtask.network.url

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DynamicURLManager @Inject constructor() {
    private var url: String? = null

    fun saveURL(url: String) {
        this.url = url
    }

    fun getURL(): String {
        checkNotNull(url) { "API URL is missing!" }
        return url!!
    }
}
