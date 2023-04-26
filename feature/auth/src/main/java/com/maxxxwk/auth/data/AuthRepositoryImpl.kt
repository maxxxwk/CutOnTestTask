package com.maxxxwk.auth.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.auth.domain.AuthRepository
import com.maxxxwk.auth.domain.models.Credentials
import com.maxxxwk.auth.domain.models.DeviceInfo
import javax.inject.Inject
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class AuthRepositoryImpl @Inject constructor(
    private val tokenManager: AuthTokenManager,
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : AuthRepository {
    override suspend fun login(
        credentials: Credentials,
        deviceInfo: DeviceInfo
    ): Result<Unit> = withContext(dispatchersProvider.io) {
        runCatching {
            apiService.login(
                login = credentials.login,
                password = credentials.password,
                devman = deviceInfo.devman,
                devmod = deviceInfo.devmod,
                devavs = deviceInfo.devavs,
                devaid = deviceInfo.devaid
            ).let { launch { tokenManager.saveToken(it.token) } }
            Unit
        }
    }
}
