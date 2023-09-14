package com.maxxxwk.auth.presentation

import com.maxxxwk.android.text.UIText

internal sealed interface AuthResultEvent {
    data object Success : AuthResultEvent
    data class Fail(val message: UIText) : AuthResultEvent
}
