package com.maxxxwk.auth.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.auth.domain.AppInfoRepository
import com.maxxxwk.auth.domain.models.AppInfo
import com.maxxxwk.auth.domain.models.AppInfoMessageType
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class AppInfoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : AppInfoRepository {
    override suspend fun getAppInfo(): AppInfo = withContext(dispatchersProvider.io) {
        return@withContext try {
            when (apiService.getAppVersionInfo().answer) {
                1 -> AppInfo(AppInfoMessageType.UPDATE_NEEDED)
                2 -> AppInfo(AppInfoMessageType.AVAILABLE_UPDATE)
                else -> AppInfo(AppInfoMessageType.NO_MESSAGE)
            }
        } catch (e: Exception) {
            AppInfo(AppInfoMessageType.NO_MESSAGE)
        }
    }
}
