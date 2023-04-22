package com.maxxxwk.testtask.screens.logout.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.kotlin.result.wrapResult
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.screens.logout.domain.LogoutRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class LogoutRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
    private val dispatchersProvider: DispatchersProvider
) : LogoutRepository {
    override suspend fun logout(): Result<Unit> = withContext(dispatchersProvider.io) {
        wrapResult(apiService::logout)
    }
}
