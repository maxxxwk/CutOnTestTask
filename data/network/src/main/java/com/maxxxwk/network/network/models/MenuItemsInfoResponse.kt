package com.maxxxwk.network.network.models

import kotlinx.serialization.Serializable

@Serializable
data class MenuItemsInfoResponse(
    val items: List<MenuItemResponse>
)

@Serializable
data class MenuItemResponse(
    val itemId: Int,
    val itemName: String,
    val itemImage: String
)
