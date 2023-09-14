package com.maxxxwk.auth.presentation

import androidx.annotation.StringRes

internal sealed interface AuthScreenIntent {
    data class InputLogin(val value: String) : AuthScreenIntent
    data class InputPassword(val value: String) : AuthScreenIntent
    data class LoadingFinished(@StringRes val appInfoMessageStrId: Int?) : AuthScreenIntent
    data class Login(val login: String, val password: String) : AuthScreenIntent
    data object NavigateToHomeScreen : AuthScreenIntent
    data class ShowAuthErrorMessage(@StringRes val message: Int) : AuthScreenIntent
    data object AuthResultConsumed : AuthScreenIntent
    data class ChangeRememberMeState(val rememberMe: Boolean) : AuthScreenIntent
}
