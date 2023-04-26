package com.maxxxwk.testtask.screens.home.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maxxxwk.home.R


@Suppress("FunctionNaming")
@Composable
internal fun HomeScreenTopBar(
    navigateToLogout: () -> Unit = {},
    loadUserInfo: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(com.maxxxwk.android.R.string.app_name),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = navigateToLogout) {
                Icon(painter = painterResource(R.drawable.ic_close), contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = loadUserInfo) {
                Icon(painter = painterResource(R.drawable.ic_user), contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp
    )
}
