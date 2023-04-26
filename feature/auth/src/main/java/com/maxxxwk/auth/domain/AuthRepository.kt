package com.maxxxwk.auth.domain

import com.maxxxwk.auth.domain.models.Credentials
import com.maxxxwk.auth.domain.models.DeviceInfo

internal interface AuthRepository {
    suspend fun login(credentials: Credentials, deviceInfo: DeviceInfo): Result<Unit>
}
