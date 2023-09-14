package com.maxxxwk.catalog.api

import androidx.compose.runtime.Composable
import com.maxxxwk.kotlin.api.Api

interface CatalogScreenApi : Api {
    @Composable
    fun Screen(bottomBar: @Composable () -> Unit)
}
