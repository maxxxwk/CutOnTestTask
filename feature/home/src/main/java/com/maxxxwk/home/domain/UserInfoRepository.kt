package com.maxxxwk.home.domain

internal interface UserInfoRepository {
    suspend fun getUserInfo(): Result<UserInfo>
}
