package com.maxxxwk.auth.presentation

import com.maxxxwk.android.text.UIText
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed

internal sealed interface AuthScreenState {
    data object Loading : AuthScreenState
    data class AuthForm(
        val login: UIText = UIText.DynamicText(""),
        val password: UIText = UIText.DynamicText(""),
        val rememberMe: Boolean = false,
        val appInfoMessage: UIText? = null,
        val isLoading: Boolean = false,
        val authResultEvent: StateEventWithContent<AuthResultEvent> = consumed()
    ) : AuthScreenState
}
