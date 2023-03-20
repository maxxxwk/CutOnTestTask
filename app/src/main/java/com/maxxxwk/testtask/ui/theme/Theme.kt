package com.maxxxwk.testtask.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
@Suppress("FunctionNaming")
fun CutOnTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(
            primary = DarkGray,
            surface = Gray,
            background = Color.Black,
            onPrimary = LightGray,
            secondary = Green,
            onBackground = Color.White
        ),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
