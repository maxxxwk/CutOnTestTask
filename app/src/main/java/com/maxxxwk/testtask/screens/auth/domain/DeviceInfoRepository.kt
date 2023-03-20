package com.maxxxwk.testtask.screens.auth.domain

import com.maxxxwk.testtask.screens.auth.domain.models.DeviceInfo

interface DeviceInfoRepository {
    fun getDeviceInfo(): DeviceInfo
}
