package com.maxxxwk.init.di

import com.maxxxwk.init.api.InitScreenApi
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Component

@Component(
    modules = [ApiModule::class, RepositoriesModule::class],
    dependencies = [InitScreenDependencies::class]
)
@FeatureScope
internal interface InitScreenComponent {
    val api: InitScreenApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: InitScreenDependencies): InitScreenComponent
    }
}
