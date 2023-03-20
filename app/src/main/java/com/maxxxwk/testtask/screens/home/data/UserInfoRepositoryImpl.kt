package com.maxxxwk.testtask.screens.home.data

import com.maxxxwk.testtask.common.result.wrapResult
import com.maxxxwk.testtask.di.DispatcherIO
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.home.domain.UserInfo
import com.maxxxwk.testtask.screens.home.domain.UserInfoRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UserInfoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : UserInfoRepository {
    override suspend fun getUserInfo(): Result<UserInfo> = withContext(dispatcher) {
        wrapResult {
            apiService.getUserInfo().let {
                UserInfo(
                    userId = it.userId,
                    firstName = it.firstName,
                    lastName = it.lastName,
                    pmFirstName = it.pmFirstName,
                    pmLastName = it.pmLastName,
                    pmTelephone = it.pmTelephone,
                    tsFirstName = it.tsFirstName,
                    tsLastName = it.tsLastName,
                    tsTelephone = it.tsTelephone,
                    balance = it.balance,
                    bonusTitle = it.bonusTitle,
                    bonusToday = it.bonusToday,
                    bonusTotal = it.bonusTotal
                )
            }
        }
    }
}
