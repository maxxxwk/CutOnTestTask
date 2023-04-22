package com.maxxxwk.network.auth

import com.maxxxwk.network.api.NetworkSettingsManager
import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

internal class AuthInterceptor @Inject constructor(
    private val authTokenManager: NetworkSettingsManager
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
                            .addQueryParameter("token", authTokenManager.getAuthToken()).build()
                    ).build()
            } else {
                chain.request()
            }
        )
    }
}
