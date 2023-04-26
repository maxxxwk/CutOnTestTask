package com.maxxxwk.logout.presentation

import com.maxxxwk.android.events.StateEvent
import com.maxxxwk.android.events.StateEventWithContent
import com.maxxxwk.android.events.consumed
import com.maxxxwk.android.text.UIText

internal sealed interface LogoutScreenState {
    data class Pending(
        val errorEvent: StateEventWithContent<UIText> = consumed()
    ) : LogoutScreenState
    data class Loading(val closeAppEvent: StateEvent = consumed) : LogoutScreenState
}
