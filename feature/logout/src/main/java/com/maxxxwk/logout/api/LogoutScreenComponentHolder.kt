package com.maxxxwk.logout.api

import com.maxxxwk.kotlin.api.ComponentHolder
import com.maxxxwk.logout.di.apiModule
import com.maxxxwk.logout.di.repositoriesModule
import com.maxxxwk.logout.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object LogoutScreenComponentHolder : ComponentHolder<LogoutScreenDependencies, LogoutScreenApi> {
    internal var koinApp: KoinApplication? = null

    override fun init(dependencies: LogoutScreenDependencies) {
        if (koinApp == null) {
            synchronized(LogoutScreenComponentHolder::class.java) {
                if (koinApp == null) {
                    koinApp = koinApplication {
                        androidLogger()
                        modules(
                            module {
                                factory { dependencies.dispatchersProvider }
                                factory { dependencies.apiService }
                                factory { dependencies.authTokenManager }
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

    override fun getApi(): LogoutScreenApi {
        requireNotNull(koinApp) { "LogoutScreenComponent isn't initialised" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
