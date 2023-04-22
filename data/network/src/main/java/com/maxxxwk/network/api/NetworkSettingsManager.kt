package com.maxxxwk.network.api

interface NetworkSettingsManager {
    fun getDynamicURL(): String
    fun getAuthToken(): String
}
