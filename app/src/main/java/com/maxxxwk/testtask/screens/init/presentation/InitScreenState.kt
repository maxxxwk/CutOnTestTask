package com.maxxxwk.testtask.screens.init.presentation

import com.maxxxwk.android.events.StateEvent
import com.maxxxwk.android.events.consumed
import com.maxxxwk.android.text.UIText

data class InitScreenState(
    val errorMessage: UIText? = null,
    val navigateToAuthScreenEvent: StateEvent = consumed
)
