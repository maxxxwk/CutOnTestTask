package com.maxxxwk.init.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.android.R
import com.maxxxwk.android.events.triggered
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.viewmodel.BaseViewModel
import com.maxxxwk.init.domain.InitRepository
import com.maxxxwk.init.domain.NetworkConnectionAvailabilityUseCase
import com.maxxxwk.local_preferences.auth.AuthTokenManager
import javax.inject.Inject
import kotlinx.coroutines.launch

internal class InitScreenViewModel @Inject constructor(
    private val initRepository: InitRepository,
    private val networkConnectionAvailabilityUseCase: NetworkConnectionAvailabilityUseCase,
    private val authTokenManager: AuthTokenManager
) : BaseViewModel<InitScreenState, InitScreenIntent>(InitScreenState()) {

    init {
        viewModelScope.launch {
            intents.send(InitScreenIntent.Init)
        }
    }

    override fun reduce(intent: InitScreenIntent): InitScreenState = when (intent) {
        InitScreenIntent.Init -> {
            init()
            state.value.copy(errorMessage = null)
        }
        is InitScreenIntent.ShowError -> state.value.copy(errorMessage = intent.message)
        InitScreenIntent.NavigateToAuthScreen -> state.value.copy(navigateToAuthScreenEvent = triggered)
        InitScreenIntent.NavigateToMainScreen -> state.value.copy(navigateToMainScreenEvent = triggered)
    }

    private fun init() = viewModelScope.launch {
        if (networkConnectionAvailabilityUseCase()) {
            val result = initRepository.init()
            result.getOrNull()?.let { navigateToNextScreen() }
            result.exceptionOrNull()?.let { throwable ->
                intents.send(
                    InitScreenIntent.ShowError(
                        throwable.message?.let { UIText.DynamicText(it) }
                            ?: UIText.StringResource(R.string.unknown_error)
                    )
                )
            }
        } else {
            intents.send(InitScreenIntent.ShowError(UIText.StringResource(R.string.no_internet_connection_error)))
        }
    }

    private fun navigateToNextScreen() = viewModelScope.launch {
        if (authTokenManager.hasToken()) {
            intents.send(InitScreenIntent.NavigateToMainScreen)
        } else {
            intents.send(InitScreenIntent.NavigateToAuthScreen)
        }
    }

    fun onRetry() {
        viewModelScope.launch {
            intents.send(InitScreenIntent.Init)
        }
    }
}
