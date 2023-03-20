package com.maxxxwk.testtask.screens.logout.presentation

import com.maxxxwk.testtask.common.composeStateEvents.StateEvent
import com.maxxxwk.testtask.common.composeStateEvents.StateEventWithContent
import com.maxxxwk.testtask.common.composeStateEvents.consumed
import com.maxxxwk.testtask.common.text.UIText

sealed interface LogoutScreenState {
    data class Pending(val errorEvent: StateEventWithContent<UIText> = consumed()) :
        LogoutScreenState

    data class Loading(val closeAppEvent: StateEvent = consumed) : LogoutScreenState
}
