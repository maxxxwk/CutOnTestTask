package com.maxxxwk.network.di

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.network.api.NetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class ApiModule {
    @Provides
    @FeatureScope
    fun provideNetworkApi(retrofit: Retrofit): NetworkApi {
        return retrofit.create(NetworkApi::class.java)
    }
}
