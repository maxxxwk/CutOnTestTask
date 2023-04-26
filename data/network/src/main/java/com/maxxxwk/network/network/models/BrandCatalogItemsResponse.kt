package com.maxxxwk.network.network.models

import kotlinx.serialization.Serializable

@Serializable
data class BrandCatalogItemsResponse(
    val brands: Map<String, BrandCatalogItem>
)

@Serializable
data class BrandCatalogItem(
    val brandId: Int,
    val brandName: String,
    val brandImage: String
)
