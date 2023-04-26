package com.maxxxwk.logout.di

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.logout.api.LogoutScreenApi
import com.maxxxwk.logout.api.LogoutScreenDependencies
import dagger.Component

@Component(
    modules = [ApiModule::class, RepositoriesModule::class],
    dependencies = [LogoutScreenDependencies::class]
)
@FeatureScope
internal interface LogoutScreenComponent {
    val api: LogoutScreenApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: LogoutScreenDependencies): LogoutScreenComponent
    }
}
