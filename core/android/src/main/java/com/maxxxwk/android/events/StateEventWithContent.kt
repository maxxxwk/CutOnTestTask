package com.maxxxwk.android.events

import androidx.compose.runtime.Stable

@Stable
sealed interface StateEventWithContent<T>

internal class StateEventWithContentTriggered<T>(val content: T) : StateEventWithContent<T>
internal class StateEventWithContentConsumed<T> : StateEventWithContent<T>

fun <T> triggered(content: T): StateEventWithContent<T> = StateEventWithContentTriggered(content)

fun <T> consumed(): StateEventWithContent<T> = StateEventWithContentConsumed()
