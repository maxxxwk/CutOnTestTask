package com.maxxxwk.testtask.screens.home.presentation

import com.maxxxwk.testtask.common.text.UIText
import com.maxxxwk.testtask.screens.home.domain.MenuItem
import com.maxxxwk.testtask.screens.home.domain.UserInfo
import kotlinx.collections.immutable.ImmutableList

sealed interface HomeScreenIntent {
    object LoadUserInfo : HomeScreenIntent
    data class ShowUserInfo(val userInfo: UserInfo) : HomeScreenIntent
    data class ShowMenu(val menuItems: ImmutableList<MenuItem>) : HomeScreenIntent
    object RetryLoadingMenu : HomeScreenIntent
    data class ShowError(val message: UIText) : HomeScreenIntent
}
