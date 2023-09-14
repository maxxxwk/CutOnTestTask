package com.maxxxwk.network.auth

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

internal class AuthInterceptor(private val authTokenProvider: AuthTokenProvider) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNeedAuth = chain.request().tag(Invocation::class.java)?.method()
            ?.getAnnotation(Auth::class.java) != null
        val request = chain.request()
        return chain.proceed(
            if (isNeedAuth) {
                chain.request()
                    .newBuilder()
                    .url(
                        request.url.newBuilder()
                            .addQueryParameter(
                                name = "token",
                                value = runBlocking { authTokenProvider.getAuthToken() }
                            ).build()
                    ).build()
            } else {
                chain.request()
            }
        )
    }
}
