package com.maxxxwk.logout.domain

internal interface LogoutRepository {
    suspend fun logout(): Result<Unit>
}
