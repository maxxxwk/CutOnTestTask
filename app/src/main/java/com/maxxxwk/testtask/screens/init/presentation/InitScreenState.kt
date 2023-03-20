package com.maxxxwk.testtask.screens.init.presentation

import com.maxxxwk.testtask.common.composeStateEvents.StateEvent
import com.maxxxwk.testtask.common.composeStateEvents.consumed
import com.maxxxwk.testtask.common.text.UIText

data class InitScreenState(
    val errorMessage: UIText? = null,
    val navigateToAuthScreenEvent: StateEvent = consumed
)
