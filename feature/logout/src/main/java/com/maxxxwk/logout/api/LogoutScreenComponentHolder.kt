package com.maxxxwk.logout.api

import com.maxxxwk.kotlin.api.ComponentHolder
import com.maxxxwk.logout.di.DaggerLogoutScreenComponent
import com.maxxxwk.logout.di.LogoutScreenComponent

object LogoutScreenComponentHolder:ComponentHolder<LogoutScreenDependencies, LogoutScreenApi> {
    private var component: LogoutScreenComponent? = null

    override fun init(dependencies: LogoutScreenDependencies) {
        if (component == null) {
            synchronized(LogoutScreenComponentHolder::class.java) {
                if (component == null) {
                    component = DaggerLogoutScreenComponent.factory().create(dependencies)
                }
            }
        }
    }

    override fun getApi(): LogoutScreenApi {
        requireNotNull(component) { "LogoutScreenComponent isn't initialised" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
