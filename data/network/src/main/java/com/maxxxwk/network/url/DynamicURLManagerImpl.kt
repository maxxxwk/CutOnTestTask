package com.maxxxwk.network.url

internal class DynamicURLManagerImpl : DynamicURLManager {
    private var url: String? = null

    override fun saveURL(url: String) {
        this.url = url
    }

    override fun getURL(): String {
        requireNotNull(url) { "URL is missing!" }
        return url!!
    }
}
