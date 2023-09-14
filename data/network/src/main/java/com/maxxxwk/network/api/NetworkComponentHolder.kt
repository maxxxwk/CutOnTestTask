package com.maxxxwk.network.api

import com.maxxxwk.kotlin.api.ComponentHolder
import com.maxxxwk.network.di.apiModule
import com.maxxxwk.network.di.networkModule
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object NetworkComponentHolder : ComponentHolder<NetworkDependencies, NetworkApi> {

    private var koinApp: KoinApplication? = null

    override fun init(dependencies: NetworkDependencies) {
        if (koinApp == null) {
            synchronized(NetworkComponentHolder::class.java) {
                if (koinApp == null) {
                    koinApp = koinApplication {
                        modules(
                            module {
                                factory { dependencies.dispatchersProvider }
                                factory { dependencies.authTokenProvider }
                            },
                            networkModule,
                            apiModule
                        )
                    }
                }
            }
        }
    }

    override fun getApi(): NetworkApi {
        checkNotNull(koinApp) { "NetworkComponent isn't initialised!" }
        return koinApp!!.koin.get()
    }

    override fun reset() {
        koinApp = null
    }
}
