package com.maxxxwk.init.api

import com.maxxxwk.init.di.apiModule
import com.maxxxwk.init.di.repositoriesModule
import com.maxxxwk.init.di.useCasesModule
import com.maxxxwk.init.di.viewModelModule
import com.maxxxwk.kotlin.api.ComponentHolder
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object InitScreenComponentHolder : ComponentHolder<InitScreenDependencies, InitScreenApi> {

    internal var koinApp: KoinApplication? = null

    override fun init(dependencies: InitScreenDependencies) {
        if (koinApp == null) {
            synchronized(InitScreenComponentHolder::class.java) {
                if (koinApp == null) {
                    koinApp = koinApplication {
                        androidContext(dependencies.context)
                        androidLogger()
                        modules(
                            module {
                                factory { dependencies.dispatchersProvider }
                                factory { dependencies.authTokenManager }
                                factory { dependencies.dynamicURLManager }
                                factory { dependencies.apiService }
                            },
                            repositoriesModule,
                            useCasesModule,
                            viewModelModule,
                            apiModule
                        )
                    }
                }
            }
        }
    }

    override fun getApi(): InitScreenApi {
        requireNotNull(koinApp) { "InitScreenComponent isn't initialised!" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
