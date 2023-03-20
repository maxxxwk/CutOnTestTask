package com.maxxxwk.testtask.screens.init.data

import com.maxxxwk.testtask.common.result.wrapResult
import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.network.url.DynamicURLManager
import com.maxxxwk.testtask.screens.init.domain.InitRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class InitRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val urlManager: DynamicURLManager,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : InitRepository {
    override suspend fun init(): Result<Unit> = withContext(dispatcher) {
        wrapResult {
            apiService.getRoute().let {
                urlManager.saveURL(it.route)
            }
        }
    }
}
