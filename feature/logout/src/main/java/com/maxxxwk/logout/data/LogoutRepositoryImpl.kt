package com.maxxxwk.logout.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.logout.domain.LogoutRepository
import com.maxxxwk.network.api.NetworkApi
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class LogoutRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
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
