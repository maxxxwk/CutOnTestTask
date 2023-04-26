package com.maxxxwk.catalog.di

import com.maxxxwk.catalog.api.CatalogScreenApi
import com.maxxxwk.catalog.api.CatalogScreenDependencies
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Component

@Component(
    modules = [ApiModule::class, RepositoriesModule::class],
    dependencies = [CatalogScreenDependencies::class]
)
@FeatureScope
internal interface CatalogScreenComponent {
    val api: CatalogScreenApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: CatalogScreenDependencies): CatalogScreenComponent
    }
}
