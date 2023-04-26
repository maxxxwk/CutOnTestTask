package com.maxxxwk.network.url

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import javax.inject.Inject

@FeatureScope
internal class DynamicURLManagerImpl @Inject constructor(): DynamicURLManager {
    private var url: String? = null

    override fun saveURL(url: String) {
        this.url = url
    }

    override fun getURL(): String {
        requireNotNull(url) { "URL is missing!" }
        return url!!
    }
}
