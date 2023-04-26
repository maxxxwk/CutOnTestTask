package com.maxxxwk.network.auth

interface AuthTokenProvider {
    suspend fun getAuthToken(): String
}
