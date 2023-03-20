package com.maxxxwk.testtask.screens.auth.data

import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.auth.domain.AppInfoRepository
import com.maxxxwk.testtask.screens.auth.domain.models.AppInfo
import com.maxxxwk.testtask.screens.auth.domain.models.AppInfoMessageType
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AppInfoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : AppInfoRepository {
    override suspend fun getAppInfo(): AppInfo = withContext(dispatcher) {
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
