package com.maxxxwk.testtask.network.auth

import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

@Singleton
class AuthInterceptor @Inject constructor(
    private val authTokenManager: AuthTokenManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNeedAuth = chain.request().tag(Invocation::class.java)?.method()
            ?.getAnnotation(Auth::class.java) != null

        return chain.proceed(
            if (isNeedAuth) {
                chain.request()
                    .newBuilder()
                    .url(
                        chain.request().url.newBuilder()
                            .addQueryParameter("token", authTokenManager.getToken()).build()
                    ).build()
            } else {
                chain.request()
            }
        )
    }
}
