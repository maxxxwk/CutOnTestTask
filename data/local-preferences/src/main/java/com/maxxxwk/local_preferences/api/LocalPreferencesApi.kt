package com.maxxxwk.local_preferences.api

import com.maxxxwk.kotlin.api.Api
import com.maxxxwk.local_preferences.auth.AuthTokenManager

interface LocalPreferencesApi : Api {
    val authTokenManager: AuthTokenManager
}
