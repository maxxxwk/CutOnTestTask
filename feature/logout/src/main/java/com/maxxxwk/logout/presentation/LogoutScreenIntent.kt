package com.maxxxwk.logout.presentation

import com.maxxxwk.android.text.UIText

internal sealed interface LogoutScreenIntent {
    data object Logout : LogoutScreenIntent
    data object CloseApp : LogoutScreenIntent
    data class ShowError(val message: UIText) : LogoutScreenIntent
    data object ErrorShowed : LogoutScreenIntent
}
