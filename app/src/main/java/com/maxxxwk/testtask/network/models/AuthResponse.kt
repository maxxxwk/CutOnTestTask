package com.maxxxwk.testtask.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val token: String
)
