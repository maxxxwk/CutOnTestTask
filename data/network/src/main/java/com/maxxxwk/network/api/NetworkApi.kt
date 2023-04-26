package com.maxxxwk.network.api

import com.maxxxwk.network.api.models.AppVersionInfoResponse
import com.maxxxwk.network.api.models.AuthResponse
import com.maxxxwk.network.api.models.BrandCatalogItemsResponse
import com.maxxxwk.network.api.models.MenuItemsInfoResponse
import com.maxxxwk.network.api.models.RouteResponse
import com.maxxxwk.network.api.models.UserInfoResponse
import com.maxxxwk.network.auth.Auth
import com.maxxxwk.network.url.DynamicURL
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NetworkApi {
    @GET("routes/")
    suspend fun getRoute(
        @Query("appName") appName: String = APP_NAME,
        @Query("v") v: Int = BUILD_NUMBER
    ): RouteResponse

    @GET("app/version/latest/")
    @DynamicURL
    suspend fun getAppVersionInfo(
        @Query("v") v: Int = BUILD_NUMBER
    ): AppVersionInfoResponse

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

    private companion object {
        const val APP_NAME = "cuton"
        const val BUILD_NUMBER = 36
    }
}
