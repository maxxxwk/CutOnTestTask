package com.maxxxwk.logout.presentation

import com.maxxxwk.android.text.UIText

internal sealed interface LogoutScreenIntent {
    object Logout : LogoutScreenIntent
    object CloseApp : LogoutScreenIntent
    data class ShowError(val message: UIText) : LogoutScreenIntent
    object ErrorShowed : LogoutScreenIntent
}
