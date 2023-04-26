package com.maxxxwk.init.domain

internal interface InitRepository {
    suspend fun init(): Result<Unit>
}
