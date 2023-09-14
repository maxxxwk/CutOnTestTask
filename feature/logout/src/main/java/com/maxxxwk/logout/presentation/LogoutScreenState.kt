package com.maxxxwk.logout.presentation

import com.maxxxwk.android.text.UIText
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed

internal sealed interface LogoutScreenState {
    data class Pending(
        val errorEvent: StateEventWithContent<UIText> = consumed()
    ) : LogoutScreenState
    data class Loading(val closeAppEvent: StateEvent = consumed) : LogoutScreenState
}
