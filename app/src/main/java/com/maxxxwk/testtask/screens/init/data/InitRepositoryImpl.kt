package com.maxxxwk.testtask.screens.init.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.kotlin.result.wrapResult
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.testtask.network.url.DynamicURLManager
import com.maxxxwk.testtask.screens.init.domain.InitRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class InitRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
    private val urlManager: DynamicURLManager,
    private val dispatchersProvider: DispatchersProvider
) : InitRepository {
    override suspend fun init(): Result<Unit> = withContext(dispatchersProvider.io) {
        wrapResult { apiService.getRoute().let { urlManager.url = it.route } }
    }
}
