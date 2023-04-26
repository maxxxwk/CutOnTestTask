package com.maxxxwk.local_preferences.api

import com.maxxxwk.local_preferences.auth.AuthTokenManager

interface LocalPreferencesApi {
    val authTokenManager: AuthTokenManager
}
