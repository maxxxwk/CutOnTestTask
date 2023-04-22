package com.maxxxwk.testtask.screens.auth.presentation

import com.maxxxwk.android.events.StateEventWithContent
import com.maxxxwk.android.events.consumed
import com.maxxxwk.android.text.UIText

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
