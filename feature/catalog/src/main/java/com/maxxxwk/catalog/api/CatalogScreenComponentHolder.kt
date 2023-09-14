package com.maxxxwk.catalog.api

import com.maxxxwk.catalog.di.apiModule
import com.maxxxwk.catalog.di.repositoriesModule
import com.maxxxwk.catalog.di.viewModelModule
import com.maxxxwk.kotlin.api.ComponentHolder
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object CatalogScreenComponentHolder : ComponentHolder<CatalogScreenDependencies, CatalogScreenApi> {
    internal var koinApp: KoinApplication? = null

    override fun init(dependencies: CatalogScreenDependencies) {
        if (koinApp == null) {
            synchronized(CatalogScreenComponentHolder::class.java) {
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

    override fun getApi(): CatalogScreenApi {
        requireNotNull(koinApp) { "CatalogScreenComponent isn't initialised" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
