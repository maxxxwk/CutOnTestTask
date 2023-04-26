package com.maxxxwk.catalog.api

import androidx.compose.runtime.Composable

interface CatalogScreenApi {
    @Composable
    fun Screen(bottomBar: @Composable () -> Unit)
}
