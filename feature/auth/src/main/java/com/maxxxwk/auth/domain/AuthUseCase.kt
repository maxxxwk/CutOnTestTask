package com.maxxxwk.auth.domain

import com.maxxxwk.auth.domain.models.Credentials

internal class AuthUseCase(
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
