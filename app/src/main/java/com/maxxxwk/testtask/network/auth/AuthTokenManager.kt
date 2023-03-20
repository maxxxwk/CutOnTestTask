package com.maxxxwk.testtask.network.auth

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthTokenManager @Inject constructor() {
    private var token: String? = null

    fun saveToken(token: String) {
        this.token = token
    }

    fun getToken(): String {
        checkNotNull(token) { "Token is missing!" }
        return token!!
    }

    fun hasToken() = token != null
}
