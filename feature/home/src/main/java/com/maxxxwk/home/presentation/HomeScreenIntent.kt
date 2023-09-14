package com.maxxxwk.home.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.home.domain.MenuItem
import com.maxxxwk.home.domain.UserInfo
import kotlinx.collections.immutable.ImmutableList

internal sealed interface HomeScreenIntent {
    data object LoadUserInfo : HomeScreenIntent
    data class ShowUserInfo(val userInfo: UserInfo) : HomeScreenIntent
    data class ShowMenu(val menuItems: ImmutableList<MenuItem>) : HomeScreenIntent
    data object RetryLoadingMenu : HomeScreenIntent
    data class ShowError(val message: UIText) : HomeScreenIntent
}
