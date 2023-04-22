package com.maxxxwk.android.events

sealed interface StateEvent

internal object Triggered : StateEvent
internal object Consumed : StateEvent

val triggered: StateEvent = Triggered
val consumed: StateEvent = Consumed
