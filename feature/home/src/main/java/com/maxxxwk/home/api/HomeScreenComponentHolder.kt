package com.maxxxwk.home.api

import com.maxxxwk.home.di.DaggerHomeScreenComponent
import com.maxxxwk.home.di.HomeScreenComponent
import com.maxxxwk.kotlin.api.ComponentHolder

object HomeScreenComponentHolder : ComponentHolder<HomeScreenDependencies, HomeScreenApi> {
    private var component: HomeScreenComponent? = null

    override fun init(dependencies: HomeScreenDependencies) {
        if (component == null) {
            synchronized(HomeScreenComponentHolder::class.java) {
                if (component == null) {
                    component = DaggerHomeScreenComponent.factory().create(dependencies)
                }
            }
        }
    }

    override fun getApi(): HomeScreenApi {
        requireNotNull(component) { "HomeScreenComponent isn't initialised" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
