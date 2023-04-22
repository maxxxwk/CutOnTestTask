@file:Suppress("FunctionNaming")

package com.maxxxwk.testtask.screens.auth.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.maxxxwk.android.events.EventEffect
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.R
import com.maxxxwk.testtask.screens.auth.presentation.components.CredentialsTextField
import com.maxxxwk.testtask.ui.components.CommonButton

@Composable
fun AuthScreen(viewModel: AuthScreenViewModel, navigateToHomeScreen: () -> Unit) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    when (state) {
        is AuthScreenState.AuthForm -> {
            EventEffect(
                event = (state as AuthScreenState.AuthForm).authResultEvent,
                onConsumed = viewModel::onAuthResultEventConsumed,
                action = {
                    when (it) {
                        AuthResultEvent.Success -> navigateToHomeScreen()
                        is AuthResultEvent.Fail -> {
                            Toast.makeText(
                                context,
                                it.message.asString(context),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            )
            AuthScreenContent(
                authFormState = (state as AuthScreenState.AuthForm),
                onLoginInput = viewModel::onLoginInput,
                onPasswordInput = viewModel::onPasswordInput,
                onChangeRememberMeState = viewModel::onChangeRememberMeState,
                onLoginClicked = viewModel::onLoginClicked
            )
        }
        AuthScreenState.Loading -> AuthScreenLoading()
    }
}

@Composable
private fun AuthScreenLoading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = MaterialTheme.colors.onBackground)
    }
}

@Composable
private fun AuthScreenContent(
    authFormState: AuthScreenState.AuthForm,
    onLoginInput: (String) -> Unit,
    onPasswordInput: (String) -> Unit,
    onChangeRememberMeState: (Boolean) -> Unit,
    onLoginClicked: (String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(R.string.auth_screen_title),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        AuthForm(
            isLoading = authFormState.isLoading,
            login = authFormState.login.asString(),
            password = authFormState.password.asString(),
            rememberMe = authFormState.rememberMe,
            onLoginInput = onLoginInput,
            onPasswordInput = onPasswordInput,
            onChangeRememberMeState = onChangeRememberMeState,
            onLoginClicked = onLoginClicked
        )
        Spacer(modifier = Modifier.weight(1f))
        AppInfo(authFormState.appInfoMessage)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.no_account_text),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = stringResource(R.string.register_text),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Composable
private fun AppInfo(appInfoMessage: UIText?) {
    appInfoMessage?.let {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.width(104.dp),
                text = appInfoMessage.asString(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.update_now_text),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary
            )
        }
    }
}

@Suppress("LongParameterList", "LongMethod")
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ColumnScope.AuthForm(
    isLoading: Boolean,
    login: String,
    password: String,
    rememberMe: Boolean,
    onLoginInput: (String) -> Unit,
    onPasswordInput: (String) -> Unit,
    onChangeRememberMeState: (Boolean) -> Unit,
    onLoginClicked: (String, String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    CredentialsTextField(
        keyboardType = KeyboardType.Phone,
        onAction = { focusManager.moveFocus(FocusDirection.Next) },
        imeAction = ImeAction.Next,
        hintText = stringResource(R.string.phone_field_hint),
        value = login,
        onValueChange = onLoginInput
    )
    Spacer(modifier = Modifier.height(32.dp))
    CredentialsTextField(
        keyboardType = KeyboardType.Password,
        onAction = {
            focusManager.clearFocus()
            onLoginClicked(login, password)
        },
        imeAction = ImeAction.Go,
        hintText = stringResource(R.string.password_field_hint),
        value = password,
        onValueChange = onPasswordInput
    )
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = onChangeRememberMeState,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.onBackground,
                        uncheckedColor = MaterialTheme.colors.onBackground,
                        checkmarkColor = MaterialTheme.colors.primary
                    ),
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.remember_me_text),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondary
            )
        }
        Text(
            text = stringResource(R.string.forgot_password_text),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground
        )
    }
    Spacer(modifier = Modifier.weight(1f))
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colors.secondary)
        }
    } else {
        CommonButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            text = stringResource(R.string.login_button_text),
            onClick = { onLoginClicked(login, password) }
        )
    }
}
