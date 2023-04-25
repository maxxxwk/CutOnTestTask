package com.maxxxwk.testtask.screens.logout.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.local_preferences.api.AuthTokenManager
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.screens.logout.domain.LogoutRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class LogoutRepositoryImpl @Inject constructor(
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
