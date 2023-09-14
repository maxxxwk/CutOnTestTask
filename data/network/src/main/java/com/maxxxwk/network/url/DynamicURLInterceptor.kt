package com.maxxxwk.network.url

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

internal class DynamicURLInterceptor(private val dynamicURLManager: DynamicURLManager) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNeedDynamicURL = chain.request().tag(Invocation::class.java)?.method()
            ?.getAnnotation(DynamicURL::class.java) != null

        return chain.proceed(
            if (isNeedDynamicURL) {
                val url = chain.request().url
                val newUrl = dynamicURLManager.getURL().toHttpUrl().host.let {
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
