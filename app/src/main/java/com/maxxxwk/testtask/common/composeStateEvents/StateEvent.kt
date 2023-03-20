package com.maxxxwk.testtask.common.composeStateEvents

sealed interface StateEvent

internal object Triggered : StateEvent
internal object Consumed : StateEvent

val triggered: StateEvent = Triggered
val consumed: StateEvent = Consumed
