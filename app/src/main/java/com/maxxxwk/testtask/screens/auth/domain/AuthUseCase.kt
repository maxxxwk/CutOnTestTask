package com.maxxxwk.testtask.screens.auth.domain

import com.maxxxwk.testtask.screens.auth.domain.models.Credentials
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val deviceInfoRepository: DeviceInfoRepository
) {
    suspend operator fun invoke(login: String, password: String): Result<Unit> {
        return authRepository.login(
            credentials = Credentials(login, password),
            deviceInfo = deviceInfoRepository.getDeviceInfo()
        )
    }
}
