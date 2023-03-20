package com.maxxxwk.testtask.screens.init.presentation

import com.maxxxwk.testtask.common.text.UIText

sealed interface InitScreenIntent {
    object Init : InitScreenIntent
    data class ShowError(val message: UIText) : InitScreenIntent
    object NavigateToLoginScreen : InitScreenIntent
}
