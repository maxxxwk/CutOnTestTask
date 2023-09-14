package com.maxxxwk.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.maxxxwk.network.auth.AuthInterceptor
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.network.url.DynamicURLInterceptor
import com.maxxxwk.network.url.DynamicURLManager
import com.maxxxwk.network.url.DynamicURLManagerImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

internal val networkModule = module {
    single<DynamicURLManager> { DynamicURLManagerImpl() }
    factoryOf(::AuthInterceptor)
    factoryOf(::DynamicURLInterceptor)
    factory {
        OkHttpClient.Builder()
            .addInterceptor(get<AuthInterceptor>())
            .addInterceptor(get<DynamicURLInterceptor>())
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }
    factory {
        val json = Json { ignoreUnknownKeys = true }
        json.asConverterFactory("application/json".toMediaType())
    }
    factory {
        Retrofit.Builder()
            .baseUrl("https://cr-test-ribu2uaqea-ey.a.run.app/")
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    factory { get<Retrofit>().create(ApiService::class.java) }
}
