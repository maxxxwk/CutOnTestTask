package com.maxxxwk.local_preferences.auth

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

@FeatureScope
internal class AuthTokenManagerImpl @Inject constructor(
    private val context: Context,
    private val dispatchersProvider: DispatchersProvider
) : AuthTokenManager {
    private val authTokenKey = stringPreferencesKey("auth_token")
    private var cachedToken: String = ""

    override suspend fun saveToken(token: String): Unit = withContext(dispatchersProvider.io) {
        cachedToken = token
        context.dataStore.edit { it[authTokenKey] = token }
    }

    override suspend fun clearToken(): Unit = withContext(dispatchersProvider.io) {
        cachedToken = ""
        context.dataStore.edit { it[authTokenKey] = "" }
        Log.d("wtf", "clearToken(${context.dataStore.data.map { it[authTokenKey] }.first()})")
    }

    override suspend fun getToken(): String = withContext(dispatchersProvider.io) {
        if (cachedToken.isNotEmpty()) {
            return@withContext cachedToken
        } else {
            val token = context.dataStore.data.map { it[authTokenKey] }.first()
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
        val token = context.dataStore.data.map { it[authTokenKey] }.first()
        if (!token.isNullOrEmpty()) {
            cachedToken = token
            return@withContext true
        } else {
            return@withContext false
        }
    }
}