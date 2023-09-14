package com.maxxxwk.home.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.home.domain.MenuItem
import com.maxxxwk.home.domain.UserInfo
import kotlinx.collections.immutable.ImmutableList

internal sealed interface HomeScreenState {
    data object Loading : HomeScreenState
    data class Content(
        val userInfo: UserInfo? = null,
        val menuItems: ImmutableList<MenuItem>
    ) : HomeScreenState

    data class Error(val message: UIText) : HomeScreenState
}
