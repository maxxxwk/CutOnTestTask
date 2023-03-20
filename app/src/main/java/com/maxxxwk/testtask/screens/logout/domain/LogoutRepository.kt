package com.maxxxwk.testtask.screens.logout.domain

interface LogoutRepository {
    suspend fun logout(): Result<Unit>
}
