package com.maxxxwk.testtask.screens.auth.presentation

import com.maxxxwk.testtask.common.text.UIText

sealed interface AuthResultEvent {
    object Success : AuthResultEvent
    data class Fail(val message: UIText) : AuthResultEvent
}
