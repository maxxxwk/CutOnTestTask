package com.maxxxwk.local_preferences.di

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.local_preferences.api.LocalPreferencesApi
import com.maxxxwk.local_preferences.auth.AuthTokenManagerImpl
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {
    @Provides
    @FeatureScope
    fun provideApi(authTokenManagerImpl: AuthTokenManagerImpl): LocalPreferencesApi {
        return object : LocalPreferencesApi {
            override val authTokenManager: AuthTokenManager = authTokenManagerImpl
        }
    }
}
