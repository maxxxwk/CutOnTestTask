@file:Suppress("FunctionNaming")

package com.maxxxwk.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.maxxxwk.android.R
import com.maxxxwk.android.ui.components.CommonButton
import com.maxxxwk.home.domain.MenuItem
import com.maxxxwk.testtask.screens.home.presentation.HomeScreenTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun HomeScreen(
    viewModel: HomeScreenViewModel,
    navigateToLogout: () -> Unit,
    navigateToCatalog: () -> Unit,
    bottomBar: @Composable () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = bottomBar,
        topBar = {
            if (state !is HomeScreenState.Loading) {
                HomeScreenTopBar(
                    navigateToLogout = navigateToLogout,
                    loadUserInfo = viewModel::onLoadUserInfo
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        when (state) {
            is HomeScreenState.Content -> HomeScreenContent(
                content = state as HomeScreenState.Content,
                navigateToCatalog = navigateToCatalog
            )
            is HomeScreenState.Error -> HomeScreenError(
                error = state as HomeScreenState.Error,
                onRetryLoadingMenu = viewModel::onRetryLoadingMenu
            )
            HomeScreenState.Loading -> HomeScreenLoading()
        }
    }
}

@Composable
private fun HomeScreenLoading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = MaterialTheme.colors.secondary)
    }
}

@Composable
private fun HomeScreenError(error: HomeScreenState.Error, onRetryLoadingMenu: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error.message.asString(),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(32.dp))
        CommonButton(
            text = stringResource(R.string.retry_message),
            onClick = onRetryLoadingMenu
        )
    }
}

@Suppress("MagicNumber")
@Composable
private fun HomeScreenContent(content: HomeScreenState.Content, navigateToCatalog: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.menu_title),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(32.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(items = content.menuItems, key = { it.itemId }) {
                MenuItem(
                    modifier = Modifier.clickable(onClick = navigateToCatalog), /*
                        Click action should depend on itemId/itemName,
                        but it isn't implemented because we don't have other menu elements yet
                    */
                    item = it
                )
            }
        }
    }
}

@Composable
private fun MenuItem(modifier: Modifier = Modifier, item: MenuItem) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier.size(40.dp),
                model = item.itemImage,
                contentDescription = item.itemName
            )
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = item.itemName,
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Icon(
                modifier = Modifier.height(40.dp),
                painter = painterResource(com.maxxxwk.home.R.drawable.ic_arrow),
                contentDescription = null,
                tint = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(
                    Brush.linearGradient(
                        0f to MaterialTheme.colors.secondary,
                        1f to MaterialTheme.colors.primary
                    )
                )
        )
    }
}
