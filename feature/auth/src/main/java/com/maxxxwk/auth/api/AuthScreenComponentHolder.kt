package com.maxxxwk.auth.api

import com.maxxxwk.auth.di.apiModule
import com.maxxxwk.auth.di.repositoriesModule
import com.maxxxwk.auth.di.useCasesModule
import com.maxxxwk.auth.di.viewModelModule
import com.maxxxwk.kotlin.api.ComponentHolder
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object AuthScreenComponentHolder : ComponentHolder<AuthScreenDependencies, AuthScreenApi> {
    internal var koinApp: KoinApplication? = null

    override fun init(dependencies: AuthScreenDependencies) {
        if (koinApp == null) {
            synchronized(AuthScreenComponentHolder::class.java) {
                if (koinApp == null) {
                    koinApp = koinApplication {
                        androidLogger()
                        modules(
                            module {
                                factory { dependencies.apiService }
                                factory { dependencies.dispatchersProvider }
                                factory { dependencies.authTokenManager }
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

    override fun getApi(): AuthScreenApi {
        requireNotNull(koinApp) { "AuthScreenComponent isn't initialised!" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
