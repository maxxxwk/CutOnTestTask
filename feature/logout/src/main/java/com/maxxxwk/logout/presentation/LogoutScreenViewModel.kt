package com.maxxxwk.logout.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.android.R
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.viewmodel.BaseViewModel
import com.maxxxwk.logout.domain.LogoutRepository
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.launch

internal class LogoutScreenViewModel(private val logoutRepository: LogoutRepository) :
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
