package com.maxxxwk.network.api

interface NetworkSettingsManager {
    suspend fun getAuthToken(): String
    fun getDynamicURL(): String
}
