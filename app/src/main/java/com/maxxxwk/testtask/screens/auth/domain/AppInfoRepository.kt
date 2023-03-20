package com.maxxxwk.testtask.screens.auth.domain

import com.maxxxwk.testtask.screens.auth.domain.models.AppInfo

interface AppInfoRepository {
    suspend fun getAppInfo(): AppInfo
}
