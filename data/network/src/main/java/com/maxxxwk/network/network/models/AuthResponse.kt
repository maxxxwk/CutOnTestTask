package com.maxxxwk.network.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val token: String
)
