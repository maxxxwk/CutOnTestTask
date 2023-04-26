package com.maxxxwk.catalog.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.catalog.domain.Brand
import kotlinx.collections.immutable.ImmutableList

internal sealed interface CatalogScreenIntent {
    data class ShowBrands(val brands: ImmutableList<Brand>) : CatalogScreenIntent
    data class ShowError(val message: UIText) : CatalogScreenIntent
}
