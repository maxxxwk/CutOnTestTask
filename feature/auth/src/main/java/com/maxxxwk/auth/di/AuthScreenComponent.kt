package com.maxxxwk.auth.di

import com.maxxxwk.auth.api.AuthScreenApi
import com.maxxxwk.auth.api.AuthScreenDependencies
import com.maxxxwk.kotlin.di.scopes.FeatureScope
import dagger.Component

@Component(
    modules = [ApiModule::class, RepositoriesModule::class],
    dependencies = [AuthScreenDependencies::class]
)
@FeatureScope
internal interface AuthScreenComponent {
    val api: AuthScreenApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: AuthScreenDependencies): AuthScreenComponent
    }
}
