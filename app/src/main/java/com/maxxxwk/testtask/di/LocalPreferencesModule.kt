package com.maxxxwk.testtask.di

import android.content.Context
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.local_preferences.api.LocalPreferencesComponentHolder
import com.maxxxwk.local_preferences.api.LocalPreferencesDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalPreferencesModule {
    @Provides
    @Singleton
    fun provideAuthTokenManager(
        dispatchersProvider: DispatchersProvider,
        context: Context
    ): AuthTokenManager {
        LocalPreferencesComponentHolder.init(
            dependencies = object : LocalPreferencesDependencies {
                override val dispatchersProvider: DispatchersProvider = dispatchersProvider
                override val context: Context = context
            }
        )
        return LocalPreferencesComponentHolder.getApi().authTokenManager
    }
}
