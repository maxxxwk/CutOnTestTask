package com.maxxxwk.testtask.screens.logout.presentation

import com.maxxxwk.testtask.common.text.UIText

sealed interface LogoutScreenIntent {
    object Logout : LogoutScreenIntent
    object CloseApp : LogoutScreenIntent
    data class ShowError(val message: UIText) : LogoutScreenIntent
    object ErrorShowed : LogoutScreenIntent
}
