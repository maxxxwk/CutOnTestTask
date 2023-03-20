package com.maxxxwk.testtask.screens.logout.data

import com.maxxxwk.testtask.common.result.wrapResult
import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.logout.domain.LogoutRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LogoutRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : LogoutRepository {
    override suspend fun logout(): Result<Unit> = withContext(dispatcher) {
        wrapResult {
            apiService.logout()
        }
    }
}
