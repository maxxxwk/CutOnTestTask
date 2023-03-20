package com.maxxxwk.testtask.screens.auth.domain.models

data class AppInfo(
    val messageType: AppInfoMessageType = AppInfoMessageType.NO_MESSAGE
)

enum class AppInfoMessageType {
    AVAILABLE_UPDATE, UPDATE_NEEDED, NO_MESSAGE
}
