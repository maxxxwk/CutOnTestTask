package com.maxxxwk.init.presentation

import com.maxxxwk.android.text.UIText

internal sealed interface InitScreenIntent {
    data object Init : InitScreenIntent
    data class ShowError(val message: UIText) : InitScreenIntent
    data object NavigateToAuthScreen : InitScreenIntent
    data object NavigateToMainScreen : InitScreenIntent
}
