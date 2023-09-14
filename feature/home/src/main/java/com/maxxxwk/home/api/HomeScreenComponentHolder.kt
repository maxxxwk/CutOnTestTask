package com.maxxxwk.home.api

import com.maxxxwk.home.di.apiModule
import com.maxxxwk.home.di.repositoriesModule
import com.maxxxwk.home.di.viewModelModule
import com.maxxxwk.kotlin.api.ComponentHolder
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object HomeScreenComponentHolder : ComponentHolder<HomeScreenDependencies, HomeScreenApi> {
    internal var koinApp: KoinApplication? = null

    override fun init(dependencies: HomeScreenDependencies) {
        if (koinApp == null) {
            synchronized(HomeScreenComponentHolder::class.java) {
                if (koinApp == null) {
                    koinApp = koinApplication {
                        androidLogger()
                        modules(
                            module {
                                factory { dependencies.apiService }
                                factory { dependencies.dispatchersProvider }
                            },
                            repositoriesModule,
                            viewModelModule,
                            apiModule
                        )
                    }
                }
            }
        }
    }

    override fun getApi(): HomeScreenApi {
        requireNotNull(koinApp) { "HomeScreenComponent isn't initialised" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
