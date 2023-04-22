package com.maxxxwk.testtask.screens.home.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.kotlin.result.wrapResult
import com.maxxxwk.testtask.network.ApiService
import com.maxxxwk.testtask.screens.home.domain.UserInfo
import com.maxxxwk.testtask.screens.home.domain.UserInfoRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class UserInfoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : UserInfoRepository {
    override suspend fun getUserInfo(): Result<UserInfo> = withContext(dispatchersProvider.io) {
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
