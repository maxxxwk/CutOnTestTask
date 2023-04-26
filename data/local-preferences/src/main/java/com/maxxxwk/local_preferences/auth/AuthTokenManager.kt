package com.maxxxwk.local_preferences.auth

interface AuthTokenManager {
    suspend fun saveToken(token: String)
    suspend fun clearToken()
    suspend fun getToken(): String
    suspend fun hasToken(): Boolean
}
