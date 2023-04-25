package com.maxxxwk.testtask.screens.auth.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.kotlin.result.wrapEmptyResult
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.screens.auth.domain.AuthRepository
import com.maxxxwk.testtask.screens.auth.domain.models.Credentials
import com.maxxxwk.testtask.screens.auth.domain.models.DeviceInfo
import javax.inject.Inject
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthRepositoryImpl @Inject constructor(
    private val tokenManager: AuthTokenManager,
    private val apiService: NetworkApi,
    private val dispatchersProvider: DispatchersProvider
) : AuthRepository {
    override suspend fun login(
        credentials: Credentials,
        deviceInfo: DeviceInfo
    ): Result<Unit> = withContext(dispatchersProvider.io) {
        wrapEmptyResult {
            apiService.login(
                login = credentials.login,
                password = credentials.password,
                devman = deviceInfo.devman,
                devmod = deviceInfo.devmod,
                devavs = deviceInfo.devavs,
                devaid = deviceInfo.devaid
            ).let { launch { tokenManager.saveToken(it.token) } }
        }
    }
}
