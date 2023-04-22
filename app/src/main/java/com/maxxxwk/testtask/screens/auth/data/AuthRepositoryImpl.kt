package com.maxxxwk.testtask.screens.auth.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.kotlin.result.wrapResult
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.network.auth.AuthTokenManager
import com.maxxxwk.testtask.screens.auth.domain.AuthRepository
import com.maxxxwk.testtask.screens.auth.domain.models.Credentials
import com.maxxxwk.testtask.screens.auth.domain.models.DeviceInfo
import javax.inject.Inject
import kotlinx.coroutines.withContext

class AuthRepositoryImpl @Inject constructor(
    private val tokenManager: AuthTokenManager,
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : AuthRepository {
    override suspend fun login(
        credentials: Credentials,
        deviceInfo: DeviceInfo
    ): Result<Unit> = withContext(dispatchersProvider.io) {
        wrapResult {
            apiService.login(
                login = credentials.login,
                password = credentials.password,
                devman = deviceInfo.devman,
                devmod = deviceInfo.devmod,
                devavs = deviceInfo.devavs,
                devaid = deviceInfo.devaid
            ).let { tokenManager.saveToken(it.token) }
        }
    }
}
