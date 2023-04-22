package com.maxxxwk.testtask.screens.catalog.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.testtask.screens.catalog.domain.Brand
import kotlinx.collections.immutable.ImmutableList

sealed interface CatalogScreenState {
    object Loading : CatalogScreenState
    data class Content(val brands: ImmutableList<Brand>) : CatalogScreenState
    data class Error(val message: UIText) : CatalogScreenState
}
