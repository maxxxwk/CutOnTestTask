package com.maxxxwk.testtask.screens.auth.presentation

import com.maxxxwk.android.text.UIText

sealed interface AuthResultEvent {
    object Success : AuthResultEvent
    data class Fail(val message: UIText) : AuthResultEvent
}
