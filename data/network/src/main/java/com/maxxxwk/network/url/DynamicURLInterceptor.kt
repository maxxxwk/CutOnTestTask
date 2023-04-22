package com.maxxxwk.network.url

import com.maxxxwk.network.api.NetworkSettingsManager
import javax.inject.Inject
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

internal class DynamicURLInterceptor @Inject constructor(private val networkSettingsManager: NetworkSettingsManager) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNeedDynamicURL = chain.request().tag(Invocation::class.java)?.method()
            ?.getAnnotation(DynamicURL::class.java) != null

        return chain.proceed(
            if (isNeedDynamicURL) {
                val url = chain.request().url
                val newUrl = networkSettingsManager.getDynamicURL().toHttpUrl().host.let {
                    url.newBuilder()
                        .host(it)
                        .build()
                }
                chain.request().newBuilder()
                    .url(newUrl)
                    .build()
            } else {
                chain.request()
            }
        )
    }
}
