package com.maxxxwk.local_preferences.di

import com.maxxxwk.local_preferences.api.LocalPreferencesApi
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.local_preferences.auth.AuthTokenManagerImpl
import org.koin.dsl.module

internal val apiModule = module {
    factory<AuthTokenManager> { AuthTokenManagerImpl(get(), get()) }
    single<LocalPreferencesApi> {
        object : LocalPreferencesApi {
            override val authTokenManager: AuthTokenManager = get()
        }
    }
}
