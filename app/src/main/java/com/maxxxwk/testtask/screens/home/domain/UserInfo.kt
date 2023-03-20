package com.maxxxwk.testtask.screens.home.domain

data class UserInfo(
    val userId: Int,
    val firstName: String,
    val lastName: String,
    val pmFirstName: String,
    val pmLastName: String,
    val pmTelephone: String,
    val tsFirstName: String,
    val tsLastName: String,
    val tsTelephone: String,
    val balance: Int,
    val bonusToday: Int,
    val bonusTotal: Int,
    val bonusTitle: String,
)
