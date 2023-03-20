package com.maxxxwk.testtask.screens.auth.presentation

import com.maxxxwk.testtask.common.composeStateEvents.StateEventWithContent
import com.maxxxwk.testtask.common.composeStateEvents.consumed
import com.maxxxwk.testtask.common.text.UIText

sealed interface AuthScreenState {
    object Loading : AuthScreenState
    data class AuthForm(
        val login: UIText = UIText.DynamicText(""),
        val password: UIText = UIText.DynamicText(""),
        val rememberMe: Boolean = false,
        val appInfoMessage: UIText? = null,
        val isLoading: Boolean = false,
        val authResultEvent: StateEventWithContent<AuthResultEvent> = consumed()
    ) : AuthScreenState
}
