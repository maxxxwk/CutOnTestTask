package com.maxxxwk.local_preferences.api

import com.maxxxwk.kotlin.api.ComponentHolder
import com.maxxxwk.local_preferences.di.DaggerLocalPreferencesComponent
import com.maxxxwk.local_preferences.di.LocalPreferencesComponent

object LocalPreferencesComponentHolder :
    ComponentHolder<LocalPreferencesDependencies, LocalPreferencesApi> {

    private var component: LocalPreferencesComponent? = null

    override fun init(dependencies: LocalPreferencesDependencies) {
        if (component == null) {
            synchronized(LocalPreferencesComponentHolder::class.java) {
                if (component == null) {
                    component = DaggerLocalPreferencesComponent.factory().create(dependencies)
                }
            }
        }
    }

    override fun getApi(): LocalPreferencesApi {
        checkNotNull(component) { "LocalPreferencesComponentHolder isn't initialised!" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
