package com.maxxxwk.testtask.common.text

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.stringResource
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Stable
sealed interface UIText {
    data class DynamicText(val value: String) : UIText
    data class StringResource(
        @StringRes val resId: Int,
        val args: ImmutableList<Any> = emptyList<Any>().toImmutableList()
    ) : UIText

    @Composable
    fun asString(): String = when (this) {
        is DynamicText -> value
        is StringResource -> stringResource(resId, args)
    }

    fun asString(context: Context): String = when (this) {
        is DynamicText -> value
        is StringResource -> context.getString(resId, args)
    }
}
