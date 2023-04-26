package com.maxxxwk.init.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.network.ApiService
import com.maxxxwk.init.domain.InitRepository
import com.maxxxwk.network.url.DynamicURLManager
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class InitRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val urlManager: DynamicURLManager,
    private val dispatchersProvider: DispatchersProvider
) : InitRepository {
    override suspend fun init(): Result<Unit> = withContext(dispatchersProvider.io) {
        runCatching { apiService.getRoute().let { urlManager.saveURL(it.route) } }
    }
}
