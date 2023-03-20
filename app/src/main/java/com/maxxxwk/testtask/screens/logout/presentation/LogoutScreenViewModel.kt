package com.maxxxwk.testtask.screens.logout.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.testtask.R
import com.maxxxwk.testtask.common.composeStateEvents.consumed
import com.maxxxwk.testtask.common.composeStateEvents.triggered
import com.maxxxwk.testtask.common.text.UIText
import com.maxxxwk.testtask.common.viewmodel.BaseViewModel
import com.maxxxwk.testtask.screens.logout.domain.LogoutRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

class LogoutScreenViewModel @Inject constructor(private val logoutRepository: LogoutRepository) :
    BaseViewModel<LogoutScreenState, LogoutScreenIntent>(LogoutScreenState.Pending()) {

    fun onLogout() = viewModelScope.launch {
        intents.send(LogoutScreenIntent.Logout)
    }

    fun onErrorShowed() = viewModelScope.launch {
        intents.send(LogoutScreenIntent.ErrorShowed)
    }

    override fun reduce(intent: LogoutScreenIntent): LogoutScreenState = when (intent) {
        LogoutScreenIntent.Logout -> {
            logout()
            LogoutScreenState.Loading()
        }
        LogoutScreenIntent.CloseApp -> LogoutScreenState.Loading(closeAppEvent = triggered)
        is LogoutScreenIntent.ShowError -> LogoutScreenState.Pending(errorEvent = triggered(intent.message))
        LogoutScreenIntent.ErrorShowed -> (state.value as LogoutScreenState.Pending).copy(errorEvent = consumed())
    }

    private fun logout() = viewModelScope.launch {
        val result = logoutRepository.logout()
        result.getOrNull()?.let {
            intents.send(LogoutScreenIntent.CloseApp)
        }
        result.exceptionOrNull()?.let {
            intents.send(LogoutScreenIntent.ShowError(UIText.StringResource(R.string.unknown_error)))
        }
    }
}
