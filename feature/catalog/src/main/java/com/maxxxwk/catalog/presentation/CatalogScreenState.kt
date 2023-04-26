package com.maxxxwk.catalog.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.catalog.domain.Brand
import kotlinx.collections.immutable.ImmutableList

internal sealed interface CatalogScreenState {
    object Loading : CatalogScreenState
    data class Content(val brands: ImmutableList<Brand>) : CatalogScreenState
    data class Error(val message: UIText) : CatalogScreenState
}
