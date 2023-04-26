package com.maxxxwk.auth.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Suppress("LongParameterList", "FunctionNaming")
@Composable
internal fun CredentialsTextField(
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType,
    onAction: KeyboardActionScope.() -> Unit,
    imeAction: ImeAction,
    hintText: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = KeyboardActions(onAny = onAction),
        textStyle = MaterialTheme.typography.body1.copy(
            color = MaterialTheme.colors.onBackground
        ),
        visualTransformation = if (keyboardType != KeyboardType.Password) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        decorationBox = { inputField ->
            Column(modifier = modifier) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty()) {
                        Text(
                            text = hintText,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                    inputField()
                }
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        },
        cursorBrush = SolidColor(MaterialTheme.colors.onPrimary)
    )
}
