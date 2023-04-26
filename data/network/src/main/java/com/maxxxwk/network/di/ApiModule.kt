package com.maxxxwk.network.di

import com.maxxxwk.kotlin.di.scopes.FeatureScope
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLManager
import com.maxxxwk.network.api.NetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class ApiModule {
    @Provides
    @FeatureScope
    fun provideNetworkApi(apiService: ApiService, dynamicURLManager: DynamicURLManager): NetworkApi {
        return object : NetworkApi {
            override val apiService: ApiService = apiService
            override val dynamicURLManager: DynamicURLManager = dynamicURLManager
        }
    }
}
