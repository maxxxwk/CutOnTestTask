package com.maxxxwk.catalog.api

import com.maxxxwk.catalog.di.CatalogScreenComponent
import com.maxxxwk.catalog.di.DaggerCatalogScreenComponent
import com.maxxxwk.kotlin.api.ComponentHolder

object CatalogScreenComponentHolder : ComponentHolder<CatalogScreenDependencies, CatalogScreenApi> {
    private var component: CatalogScreenComponent? = null

    override fun init(dependencies: CatalogScreenDependencies) {
        if (component == null) {
            synchronized(CatalogScreenComponentHolder::class.java) {
                if (component == null) {
                    component = DaggerCatalogScreenComponent.factory().create(dependencies)
                }
            }
        }
    }

    override fun getApi(): CatalogScreenApi {
        requireNotNull(component) { "CatalogScreenComponent isn't initialised" }
        return component!!.api
    }

    override fun reset() {
        component = null
    }
}
