package com.maxxxwk.auth.api

import com.maxxxwk.auth.di.AuthScreenComponent
import com.maxxxwk.auth.di.DaggerAuthScreenComponent
import com.maxxxwk.kotlin.api.ComponentHolder

object AuthScreenComponentHolder : ComponentHolder<AuthScreenDependencies, AuthScreenApi> {
    private var component: AuthScreenComponent? = null

    override fun init(dependencies: AuthScreenDependencies) {
        if (component == null) {
            synchronized(AuthScreenComponentHolder::class.java) {
                if (component == null) {
                    component = DaggerAuthScreenComponent.factory().create(dependencies)
                }
            }
        }
    }

    override fun getApi(): AuthScreenApi {
        requireNotNull(component) { "AuthScreenComponent isn't initialised!" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
