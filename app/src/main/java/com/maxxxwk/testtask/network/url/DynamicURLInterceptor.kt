package com.maxxxwk.testtask.network.url

import androidx.core.net.toUri
import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

@Singleton
class DynamicURLInterceptor @Inject constructor(private val dynamicUrlManager: DynamicURLManager) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNeedDynamicURL = chain.request().tag(Invocation::class.java)?.method()
            ?.getAnnotation(DynamicURL::class.java) != null

        return chain.proceed(
            if (isNeedDynamicURL) {
                val url = chain.request().url
                val newUrl = dynamicUrlManager.getURL().toUri().host?.let {
                    url.newBuilder()
                        .host(it)
                        .build()
                } ?: url
                chain.request().newBuilder()
                    .url(newUrl)
                    .build()
            } else {
                chain.request()
            }
        )
    }
}
