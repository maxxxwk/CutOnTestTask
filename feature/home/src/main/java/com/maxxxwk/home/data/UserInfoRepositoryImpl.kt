package com.maxxxwk.home.data

import com.maxxxwk.kotlin.dispatchers.DispatchersProvider
import com.maxxxwk.network.api.NetworkApi
import com.maxxxwk.home.domain.UserInfo
import com.maxxxwk.home.domain.UserInfoRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

internal class UserInfoRepositoryImpl @Inject constructor(
    private val apiService: NetworkApi,
    private val dispatchersProvider: DispatchersProvider
) : UserInfoRepository {
    override suspend fun getUserInfo(): Result<UserInfo> = withContext(dispatchersProvider.io) {
        runCatching {
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
