@file:Suppress("FunctionNaming")

package com.maxxxwk.testtask.screens.logout.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maxxxwk.android.R
import com.maxxxwk.android.events.EventEffect
import com.maxxxwk.android.events.StateEventWithContent
import com.maxxxwk.android.text.UIText
import com.maxxxwk.testtask.ui.components.CommonButton

@Composable
fun LogoutScreen(viewModel: LogoutScreenViewModel, onBack: () -> Unit, closeApp: () -> Unit) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.logout_screen_title),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        when (state) {
            is LogoutScreenState.Loading -> {
                EventEffect(
                    event = (state as LogoutScreenState.Loading).closeAppEvent,
                    onConsumed = {},
                    action = closeApp
                )
                CircularProgressIndicator(color = MaterialTheme.colors.secondary)
            }
            is LogoutScreenState.Pending -> {
                LogoutScreenPending(
                    errorEvent = (state as LogoutScreenState.Pending).errorEvent,
                    onErrorShowed = viewModel::onErrorShowed,
                    onBack = onBack,
                    onLogout = viewModel::onLogout
                )
            }
        }
        Spacer(modifier = Modifier.weight(2f))
    }
}

@Composable
private fun LogoutScreenPending(
    errorEvent: StateEventWithContent<UIText>,
    onErrorShowed: () -> Unit,
    onBack: () -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current
    EventEffect(
        event = errorEvent,
        onConsumed = onErrorShowed,
        action = {
            Toast.makeText(context, it.asString(context), Toast.LENGTH_SHORT).show()
        }
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CommonButton(
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            text = stringResource(R.string.no_button_text),
            onClick = onBack,
            backgroundColor = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.width(16.dp))
        CommonButton(
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            text = stringResource(R.string.yes_button_text),
            onClick = onLogout
        )
    }
}
