package com.maxxxwk.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.maxxxwk.network.auth.AuthInterceptor
import com.maxxxwk.network.url.DynamicURLInterceptor
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

@Module
internal class NetworkModule {
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cr-test-ribu2uaqea-ey.a.run.app/")
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        val json = Json { ignoreUnknownKeys = true }
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        urlInterceptor: DynamicURLInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(urlInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }
}