package com.maxxxwk.init.presentation

import com.maxxxwk.android.text.UIText

internal sealed interface InitScreenIntent {
    object Init : InitScreenIntent
    data class ShowError(val message: UIText) : InitScreenIntent
    object NavigateToAuthScreen : InitScreenIntent
    object NavigateToMainScreen : InitScreenIntent
}
