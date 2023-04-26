package com.maxxxwk.auth.data

import android.os.Build
import com.maxxxwk.auth.domain.DeviceInfoRepository
import com.maxxxwk.auth.domain.models.DeviceInfo
import javax.inject.Inject

internal class DeviceInfoRepositoryImpl @Inject constructor() : DeviceInfoRepository {
    override fun getDeviceInfo(): DeviceInfo {
        return DeviceInfo(
            devman = Build.MANUFACTURER,
            devmod = Build.MODEL,
            devavs = Build.VERSION.SDK_INT.toString(),
            devaid = Build.ID
        )
    }
}
