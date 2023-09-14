package com.maxxxwk.local_preferences.auth

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


internal class AuthTokenManagerImpl(
    private val context: Context,
    private val dispatchersProvider: DispatchersProvider
) : AuthTokenManager {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

    private val authTokenKey = stringPreferencesKey("auth_token")
    private var cachedToken: String = ""

    override suspend fun saveToken(token: String): Unit = withContext(dispatchersProvider.io) {
        cachedToken = token
        saveTokenToStore(token)
    }

    override suspend fun clearToken(): Unit = withContext(dispatchersProvider.io) {
        cachedToken = ""
        saveTokenToStore("")
    }

    override suspend fun getToken(): String = withContext(dispatchersProvider.io) {
        if (cachedToken.isNotEmpty()) {
            return@withContext cachedToken
        } else {
            val token = getTokenFromStore()
            if (token.isNullOrEmpty()) {
                error("Token is missing!")
            } else {
                cachedToken = token
                return@withContext token
            }
        }
    }

    override suspend fun hasToken(): Boolean = withContext(dispatchersProvider.io) {
        if (cachedToken.isNotEmpty()) return@withContext true
        val token = getTokenFromStore()
        if (!token.isNullOrEmpty()) {
            cachedToken = token
            return@withContext true
        } else {
            return@withContext false
        }
    }

    private suspend inline fun saveTokenToStore(token: String) {
        context.dataStore.edit { it[authTokenKey] = token }
    }

    private suspend inline fun getTokenFromStore(): String? =
        context.dataStore.data.map { it[authTokenKey] }.first()
}