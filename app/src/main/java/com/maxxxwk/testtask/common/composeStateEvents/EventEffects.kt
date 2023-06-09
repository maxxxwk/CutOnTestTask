@file:Suppress("FunctionNaming")

package com.maxxxwk.testtask.common.composeStateEvents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun EventEffect(event: StateEvent, onConsumed: () -> Unit, action: suspend () -> Unit) {
    LaunchedEffect(key1 = event, key2 = onConsumed) {
        if (event is Triggered) {
            action()
            onConsumed()
        }
    }
}

@Composable
fun <T> EventEffect(
    event: StateEventWithContent<T>,
    onConsumed: () -> Unit,
    action: suspend (T) -> Unit
) {
    LaunchedEffect(key1 = event, key2 = onConsumed) {
        if (event is StateEventWithContentTriggered<T>) {
            action(event.content)
            onConsumed()
        }
    }
}
