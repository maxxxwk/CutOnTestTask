package com.maxxxwk.network.api.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val token: String
)
