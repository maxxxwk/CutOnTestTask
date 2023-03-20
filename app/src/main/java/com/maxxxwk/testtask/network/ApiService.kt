package com.maxxxwk.testtask.network

import com.maxxxwk.testtask.BuildConfig
import com.maxxxwk.testtask.network.auth.Auth
import com.maxxxwk.testtask.network.models.AppVersionInfoResponse
import com.maxxxwk.testtask.network.models.AuthResponse
import com.maxxxwk.testtask.network.models.BrandCatalogItemsResponse
import com.maxxxwk.testtask.network.models.MenuItemsInfoResponse
import com.maxxxwk.testtask.network.models.RouteResponse
import com.maxxxwk.testtask.network.models.UserInfoResponse
import com.maxxxwk.testtask.network.url.DynamicURL
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("routes/")
    suspend fun getRoute(
        @Query("appName") appName: String = BuildConfig.APP_NAME,
        @Query("v") v: Int = BuildConfig.BUILD_NUMBER
    ): RouteResponse

    @GET("app/version/latest/")
    @DynamicURL
    suspend fun getAppVersionInfo(@Query("v") v: Int = BuildConfig.BUILD_NUMBER): AppVersionInfoResponse

    @Suppress("LongParameterList")
    @POST("users/login/")
    @FormUrlEncoded
    @DynamicURL
    suspend fun login(
        @Field("login") login: String,
        @Field("password") password: String,
        @Field("devman") devman: String,
        @Field("devmod") devmod: String,
        @Field("devavs") devavs: String,
        @Field("devaid") devaid: String,
    ): AuthResponse

    @GET("users/")
    @DynamicURL
    @Auth
    suspend fun getUserInfo(): UserInfoResponse

    @GET("home/menu/items/")
    @DynamicURL
    @Auth
    suspend fun getMenuItems(): MenuItemsInfoResponse

    @GET("catalog/brands/")
    @DynamicURL
    @Auth
    suspend fun getBrands(): BrandCatalogItemsResponse

    @DELETE("users/")
    @DynamicURL
    @Auth
    suspend fun logout()
}
