package com.maxxxwk.home.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.android.R
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.viewmodel.BaseViewModel
import com.maxxxwk.home.domain.MenuItemsRepository
import com.maxxxwk.home.domain.UserInfoRepository
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch

internal class HomeScreenViewModel(
    private val userInfoRepository: UserInfoRepository,
    private val menuItemsRepository: MenuItemsRepository
) : BaseViewModel<HomeScreenState, HomeScreenIntent>(HomeScreenState.Loading) {

    init {
        loadMenuItems()
    }

    fun onLoadUserInfo() {
        viewModelScope.launch {
            intents.send(HomeScreenIntent.LoadUserInfo)
        }
    }

    fun onRetryLoadingMenu() {
        viewModelScope.launch {
            intents.send(HomeScreenIntent.RetryLoadingMenu)
        }
    }

    override fun reduce(intent: HomeScreenIntent): HomeScreenState = when (intent) {
        HomeScreenIntent.LoadUserInfo -> {
            loadUserInfo()
            state.value
        }

        is HomeScreenIntent.ShowUserInfo -> (state.value as HomeScreenState.Content).copy(userInfo = intent.userInfo)
        is HomeScreenIntent.ShowError -> HomeScreenState.Error(intent.message)
        is HomeScreenIntent.ShowMenu -> HomeScreenState.Content(menuItems = intent.menuItems)
        HomeScreenIntent.RetryLoadingMenu -> {
            loadMenuItems()
            HomeScreenState.Loading
        }
    }

    private fun loadUserInfo() = viewModelScope.launch {
        userInfoRepository.getUserInfo().getOrNull()?.let {
            intents.send(HomeScreenIntent.ShowUserInfo(it))
        }
    }

    private fun loadMenuItems() = viewModelScope.launch {
        val result = menuItemsRepository.getMenuItems()
        result.getOrNull()?.let {
            intents.send(HomeScreenIntent.ShowMenu(it.toImmutableList()))
        }
        result.exceptionOrNull()?.let {
            intents.send(HomeScreenIntent.ShowError(UIText.StringResource(R.string.unknown_error)))
        }
    }
}
