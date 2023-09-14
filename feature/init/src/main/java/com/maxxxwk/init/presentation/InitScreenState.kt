package com.maxxxwk.init.presentation

import com.maxxxwk.android.text.UIText
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed

internal data class InitScreenState(
    val errorMessage: UIText? = null,
    val navigateToAuthScreenEvent: StateEvent = consumed,
    val navigateToMainScreenEvent: StateEvent = consumed
)
