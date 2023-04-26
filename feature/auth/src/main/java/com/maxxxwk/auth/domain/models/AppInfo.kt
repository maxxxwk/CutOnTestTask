package com.maxxxwk.auth.domain.models

internal data class AppInfo(
    val messageType: AppInfoMessageType = AppInfoMessageType.NO_MESSAGE
)

internal enum class AppInfoMessageType {
    AVAILABLE_UPDATE, UPDATE_NEEDED, NO_MESSAGE
}
