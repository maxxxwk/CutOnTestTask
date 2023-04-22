package com.maxxxwk.testtask.screens.home.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.testtask.screens.home.domain.MenuItem
import com.maxxxwk.testtask.screens.home.domain.UserInfo
import kotlinx.collections.immutable.ImmutableList

sealed interface HomeScreenState {
    object Loading : HomeScreenState
    data class Content(
        val userInfo: UserInfo? = null,
        val menuItems: ImmutableList<MenuItem>
    ) : HomeScreenState

    data class Error(val message: UIText) : HomeScreenState
}
