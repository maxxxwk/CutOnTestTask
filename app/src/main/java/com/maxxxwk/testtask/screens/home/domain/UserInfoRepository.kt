package com.maxxxwk.testtask.screens.home.domain

interface UserInfoRepository {
    suspend fun getUserInfo(): Result<UserInfo>
}
