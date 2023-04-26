package com.maxxxwk.home.di

import com.maxxxwk.home.api.HomeScreenApi
import com.maxxxwk.home.api.HomeScreenDependencies
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Component

@Component(
    modules = [ApiModule::class, RepositoriesModule::class],
    dependencies = [HomeScreenDependencies::class]
)
@FeatureScope
internal interface HomeScreenComponent {
    val api: HomeScreenApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeScreenDependencies): HomeScreenComponent
    }
}
