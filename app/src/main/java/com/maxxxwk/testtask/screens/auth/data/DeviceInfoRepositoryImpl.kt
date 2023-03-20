package com.maxxxwk.testtask.screens.auth.data

import android.os.Build
import com.maxxxwk.testtask.screens.auth.domain.DeviceInfoRepository
import com.maxxxwk.testtask.screens.auth.domain.models.DeviceInfo
import javax.inject.Inject

class DeviceInfoRepositoryImpl @Inject constructor() : DeviceInfoRepository {
    override fun getDeviceInfo(): DeviceInfo {
        return DeviceInfo(
            devman = Build.MANUFACTURER,
            devmod = Build.MODEL,
            devavs = Build.VERSION.SDK_INT.toString(),
            devaid = Build.ID
        )
    }
}
