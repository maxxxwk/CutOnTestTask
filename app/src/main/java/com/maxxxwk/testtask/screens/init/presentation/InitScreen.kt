@file:Suppress("FunctionNaming")

package com.maxxxwk.testtask.screens.init.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maxxxwk.testtask.R
import com.maxxxwk.testtask.common.composeStateEvents.EventEffect
import com.maxxxwk.testtask.common.text.UIText
import com.maxxxwk.testtask.ui.components.CommonButton
import kotlinx.coroutines.delay

private const val DELAY_BEFORE_NAVIGATE = 200L

@Composable
fun InitScreen(
    viewModel: InitScreenViewModel,
    navigateToLoginScreen: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    EventEffect(
        event = state.navigateToAuthScreenEvent,
        onConsumed = {},
        action = {
            delay(DELAY_BEFORE_NAVIGATE)
            navigateToLoginScreen()
        }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.initialize_screen_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        state.errorMessage?.let {
            InitScreenError(
                message = it,
                onRetry = viewModel::onRetry
            )
        } ?: Image(
            painter = painterResource(R.drawable.ic_init_screen_logo),
            contentDescription = null
        )
    }
}

@Composable
private fun InitScreenError(message: UIText, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = message.asString(),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
        CommonButton(text = stringResource(R.string.retry_message), onClick = onRetry)
    }
}
