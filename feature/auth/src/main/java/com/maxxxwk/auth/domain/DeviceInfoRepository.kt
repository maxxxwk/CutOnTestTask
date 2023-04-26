package com.maxxxwk.auth.domain

import com.maxxxwk.auth.domain.models.DeviceInfo

internal interface DeviceInfoRepository {
    fun getDeviceInfo(): DeviceInfo
}
