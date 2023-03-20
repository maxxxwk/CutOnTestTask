package com.maxxxwk.testtask.screens.auth.domain

import com.maxxxwk.testtask.screens.auth.domain.models.Credentials
import com.maxxxwk.testtask.screens.auth.domain.models.DeviceInfo

interface AuthRepository {
    suspend fun login(credentials: Credentials, deviceInfo: DeviceInfo): Result<Unit>
}
