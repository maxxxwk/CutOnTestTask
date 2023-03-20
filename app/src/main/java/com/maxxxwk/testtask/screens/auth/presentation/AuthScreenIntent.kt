package com.maxxxwk.testtask.screens.auth.presentation

import androidx.annotation.StringRes

sealed interface AuthScreenIntent {
    data class InputLogin(val value: String) : AuthScreenIntent
    data class InputPassword(val value: String) : AuthScreenIntent
    data class LoadingFinished(@StringRes val appInfoMessageStrId: Int?) : AuthScreenIntent
    data class Login(val login: String, val password: String) : AuthScreenIntent
    object NavigateToHomeScreen : AuthScreenIntent
    data class ShowAuthErrorMessage(@StringRes val message: Int) : AuthScreenIntent
    object AuthResultConsumed : AuthScreenIntent
    data class ChangeRememberMeState(val rememberMe: Boolean) : AuthScreenIntent
}
