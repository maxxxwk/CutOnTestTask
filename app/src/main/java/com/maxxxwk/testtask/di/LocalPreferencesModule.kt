package com.maxxxwk.testtask.di

import android.content.Context
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.LocalPreferencesComponentHolder
import com.maxxxwk.local_preferences.api.LocalPreferencesDependencies
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localPreferencesModule = module {
    single {
        LocalPreferencesComponentHolder.init(
            dependencies = object : LocalPreferencesDependencies {
                override val dispatchersProvider: DispatchersProvider = get()
                override val context: Context = androidContext()
            }
        )
        LocalPreferencesComponentHolder.getApi().authTokenManager.also {
            LocalPreferencesComponentHolder.reset()
        }
    }
}
