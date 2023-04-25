package com.maxxxwk.local_preferences.di

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.local_preferences.api.LocalPreferencesApi
import com.maxxxwk.local_preferences.api.LocalPreferencesDependencies
import dagger.Component

@Component(dependencies = [LocalPreferencesDependencies::class], modules = [ApiModule::class])
@FeatureScope
internal interface LocalPreferencesComponent {

    val api: LocalPreferencesApi

    @Component.Factory
    interface Factory {
        fun create(localPreferencesDependencies: LocalPreferencesDependencies): LocalPreferencesComponent
    }
}
