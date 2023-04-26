package com.maxxxwk.logout.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import com.maxxxwk.logout.domain.LogoutRepository
import com.maxxxwk.network.network.ApiService
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class LogoutRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider,
    private val authTokenManager: AuthTokenManager
) : LogoutRepository {
    override suspend fun logout(): Result<Unit> = withContext(dispatchersProvider.io) {
        runCatching {
            apiService.logout()
            authTokenManager.clearToken()
        }
    }
}
