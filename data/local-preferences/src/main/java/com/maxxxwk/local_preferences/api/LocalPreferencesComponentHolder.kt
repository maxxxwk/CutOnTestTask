package com.maxxxwk.local_preferences.api

import com.maxxxwk.kotlin.api.ComponentHolder
import com.maxxxwk.local_preferences.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object LocalPreferencesComponentHolder :
    ComponentHolder<LocalPreferencesDependencies, LocalPreferencesApi> {

    private var koinApp: KoinApplication? = null

    override fun init(dependencies: LocalPreferencesDependencies) {
        if (koinApp == null) {
            synchronized(LocalPreferencesComponentHolder::class.java) {
                if (koinApp == null) {
                    koinApp = koinApplication {
                        androidLogger()
                        androidContext(dependencies.context)
                        modules(
                            module {
                                factory { dependencies.dispatchersProvider }
                            },
                            apiModule
                        )
                    }
                }
            }
        }
    }

    override fun getApi(): LocalPreferencesApi {
        checkNotNull(koinApp) { "LocalPreferencesComponent isn't initialised!" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
