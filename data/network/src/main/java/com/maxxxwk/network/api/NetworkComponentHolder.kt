package com.maxxxwk.network.api

import com.maxxxwk.kotlin.api.ComponentHolder
import com.maxxxwk.network.di.DaggerNetworkComponent
import com.maxxxwk.network.di.NetworkComponent

object NetworkComponentHolder : ComponentHolder<NetworkDependencies, NetworkApi> {
    private var component: NetworkComponent? = null

    override fun init(dependencies: NetworkDependencies) {
        if (component == null) {
            synchronized(NetworkComponentHolder::class.java) {
                if (component == null) {
                    component = DaggerNetworkComponent.factory()
                        .create(dependencies)
                }
            }
        }
    }

    override fun getApi(): NetworkApi {
        checkNotNull(component) { "NetworkComponentHolder isn't initialised!" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
