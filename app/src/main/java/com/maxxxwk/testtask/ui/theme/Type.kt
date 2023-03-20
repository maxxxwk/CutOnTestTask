package com.maxxxwk.testtask.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.maxxxwk.testtask.R

val PTSans = FontFamily(
    Font(resId = R.font.pt_sans_regular, weight = FontWeight.Normal),
    Font(resId = R.font.pt_sans_bold, weight = FontWeight.Bold)
)

val Exo2 = FontFamily(
    Font(resId = R.font.exo2_medium, weight = FontWeight.Medium),
    Font(resId = R.font.exo2_semibold, weight = FontWeight.SemiBold)
)

val Inter = FontFamily(
    Font(resId = R.font.inter_bold, weight = FontWeight.Bold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = PTSans,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    h2 = TextStyle(
        fontFamily = PTSans,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    h3 = TextStyle(
        fontFamily = PTSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    h4 = TextStyle(
        fontFamily = PTSans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        fontFamily = PTSans,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    body1 = TextStyle(
        fontFamily = Exo2,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    body2 = TextStyle(
        fontFamily = Exo2,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
)