package com.maxxxwk.network.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInfoResponse(
    @SerialName("user_id") val userId: Int,
    @SerialName("firstname") val firstName: String,
    @SerialName("lastname") val lastName: String,
    @SerialName("pmFirstname") val pmFirstName: String,
    @SerialName("pmLastname") val pmLastName: String,
    @SerialName("pmTelephone") val pmTelephone: String,
    @SerialName("tsFirstname") val tsFirstName: String,
    @SerialName("tsLastname") val tsLastName: String,
    @SerialName("tsTelephone") val tsTelephone: String,
    @SerialName("balance") val balance: Int,
    @SerialName("bonusToday") val bonusToday: Int,
    @SerialName("bonusTotal") val bonusTotal: Int,
    @SerialName("bonusTitle") val bonusTitle: String
)
