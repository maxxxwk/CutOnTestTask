package com.maxxxwk.testtask.screens.init.domain

interface InitRepository {
    suspend fun init(): Result<Unit>
}
