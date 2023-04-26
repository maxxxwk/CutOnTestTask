package com.maxxxwk.init.api

import com.maxxxwk.init.di.DaggerInitScreenComponent
import com.maxxxwk.init.di.InitScreenComponent
import com.maxxxwk.kotlin.api.ComponentHolder

object InitScreenComponentHolder : ComponentHolder<InitScreenDependencies, InitScreenApi> {

    private var component: InitScreenComponent? = null

    override fun init(dependencies: InitScreenDependencies) {
        if (component == null) {
            synchronized(InitScreenComponent::class.java) {
                if (component == null) {
                    component = DaggerInitScreenComponent.factory().create(dependencies)
                }
            }
        }
    }

    override fun getApi(): InitScreenApi {
        requireNotNull(component) { "InitScreenComponent isn't initialised!" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
