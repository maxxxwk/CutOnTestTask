package com.maxxxwk.network.di

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.network.api.NetworkDependencies
import dagger.Component

@Component(
    modules = [ApiModule::class, NetworkModule::class],
    dependencies = [NetworkDependencies::class]
)
@FeatureScope
internal interface NetworkComponent {

    val api: NetworkApi

    @Component.Factory
    interface Factory {
        fun create(networkDependencies: NetworkDependencies): NetworkComponent
    }
}
