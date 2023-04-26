package com.maxxxwk.auth.domain

import com.maxxxwk.auth.domain.models.Credentials
import javax.inject.Inject

internal class AuthUseCase @Inject constructor(
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
