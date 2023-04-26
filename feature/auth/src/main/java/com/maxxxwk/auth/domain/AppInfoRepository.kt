package com.maxxxwk.auth.domain

import com.maxxxwk.auth.domain.models.AppInfo

internal interface AppInfoRepository {
    suspend fun getAppInfo(): AppInfo
}
