package com.maxxxwk.testtask.screens.auth.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.screens.auth.domain.AppInfoRepository
import com.maxxxwk.testtask.screens.auth.domain.models.AppInfo
import com.maxxxwk.testtask.screens.auth.domain.models.AppInfoMessageType
import javax.inject.Inject
import kotlinx.coroutines.withContext

class AppInfoRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
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
