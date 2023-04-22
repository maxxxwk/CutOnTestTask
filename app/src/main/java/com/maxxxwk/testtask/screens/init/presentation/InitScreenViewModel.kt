package com.maxxxwk.testtask.screens.init.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.android.events.triggered
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.viewmodel.BaseViewModel
import com.maxxxwk.android.R
import com.maxxxwk.testtask.screens.init.domain.InitRepository
import com.maxxxwk.testtask.screens.init.domain.NetworkConnectionAvailabilityUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

class InitScreenViewModel @Inject constructor(
    private val initRepository: InitRepository,
    private val networkConnectionAvailabilityUseCase: NetworkConnectionAvailabilityUseCase
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
        InitScreenIntent.NavigateToLoginScreen -> state.value.copy(navigateToAuthScreenEvent = triggered)
    }

    private fun init() = viewModelScope.launch {
        if (networkConnectionAvailabilityUseCase()) {
            val result = initRepository.init()
            result.getOrNull()?.let {
                intents.send(InitScreenIntent.NavigateToLoginScreen)
            }
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

    fun onRetry() {
        viewModelScope.launch {
            intents.send(InitScreenIntent.Init)
        }
    }
}
