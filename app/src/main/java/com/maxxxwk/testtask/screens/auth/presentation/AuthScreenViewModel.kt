package com.maxxxwk.testtask.screens.auth.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.android.events.consumed
import com.maxxxwk.android.events.triggered
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.viewmodel.BaseViewModel
import com.maxxxwk.android.R
import com.maxxxwk.testtask.screens.auth.domain.AppInfoRepository
import com.maxxxwk.testtask.screens.auth.domain.AuthUseCase
import com.maxxxwk.testtask.screens.auth.domain.models.AppInfoMessageType
import javax.inject.Inject
import kotlinx.coroutines.launch
import retrofit2.HttpException


class AuthScreenViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val appInfoRepository: AppInfoRepository
) : BaseViewModel<AuthScreenState, AuthScreenIntent>(AuthScreenState.Loading) {

    init {
        loadAppInfo()
    }

    fun onAuthResultEventConsumed() {
        viewModelScope.launch {
            intents.send(AuthScreenIntent.AuthResultConsumed)
        }
    }

    fun onLoginClicked(login: String, password: String) {
        viewModelScope.launch {
            if (login.isBlank() || password.isBlank()) {
                intents.send(AuthScreenIntent.ShowAuthErrorMessage(R.string.empty_login_or_password_error))
            } else {
                intents.send(AuthScreenIntent.Login(login, password))
            }
        }
    }

    fun onLoginInput(value: String) {
        viewModelScope.launch {
            intents.send(AuthScreenIntent.InputLogin(value))
        }
    }

    fun onPasswordInput(value: String) {
        viewModelScope.launch {
            intents.send(AuthScreenIntent.InputPassword(value))
        }
    }

    fun onChangeRememberMeState(rememberMe: Boolean) {
        viewModelScope.launch {
            intents.send(AuthScreenIntent.ChangeRememberMeState(rememberMe))
        }
    }

    override fun reduce(intent: AuthScreenIntent): AuthScreenState = when (intent) {
        is AuthScreenIntent.InputLogin -> {
            (state.value as AuthScreenState.AuthForm).copy(login = UIText.DynamicText(intent.value))
        }
        is AuthScreenIntent.InputPassword -> {
            (state.value as AuthScreenState.AuthForm).copy(password = UIText.DynamicText(intent.value))
        }
        is AuthScreenIntent.LoadingFinished -> {
            intent.appInfoMessageStrId?.let {
                AuthScreenState.AuthForm(appInfoMessage = UIText.StringResource(it))
            } ?: AuthScreenState.AuthForm()
        }
        is AuthScreenIntent.Login -> {
            login(intent.login, intent.password)
            (state.value as AuthScreenState.AuthForm).copy(isLoading = true)
        }
        AuthScreenIntent.AuthResultConsumed -> {
            (state.value as AuthScreenState.AuthForm).copy(
                authResultEvent = consumed(),
                isLoading = false
            )
        }
        is AuthScreenIntent.ShowAuthErrorMessage -> {
            (state.value as AuthScreenState.AuthForm).copy(
                authResultEvent = triggered(
                    AuthResultEvent.Fail(UIText.StringResource(intent.message))
                )
            )
        }
        AuthScreenIntent.NavigateToHomeScreen -> {
            (state.value as AuthScreenState.AuthForm).copy(
                authResultEvent = triggered(AuthResultEvent.Success)
            )
        }
        is AuthScreenIntent.ChangeRememberMeState -> {
            (state.value as AuthScreenState.AuthForm).copy(rememberMe = intent.rememberMe)
        }
    }

    private fun loadAppInfo() = viewModelScope.launch {
        appInfoRepository.getAppInfo().let {
            val appInfoMessageStrId = when (it.messageType) {
                AppInfoMessageType.AVAILABLE_UPDATE -> R.string.update_available_message
                AppInfoMessageType.UPDATE_NEEDED -> R.string.update_needed_message
                AppInfoMessageType.NO_MESSAGE -> null
            }
            intents.send(AuthScreenIntent.LoadingFinished(appInfoMessageStrId))
        }
    }

    @Suppress("MagicNumber")
    private fun login(login: String, password: String) = viewModelScope.launch {
        val result = authUseCase(login, password)
        result.getOrNull()?.let {
            intents.send(AuthScreenIntent.NavigateToHomeScreen)
        }
        result.exceptionOrNull()?.let {
            //todo make without retrofit dependency
            if (it is HttpException && it.code() == 404) {
                intents.send(AuthScreenIntent.ShowAuthErrorMessage(R.string.incorrect_login_or_password_error))
            } else {
                intents.send(AuthScreenIntent.ShowAuthErrorMessage(R.string.unknown_error))
            }
        }
    }
}
