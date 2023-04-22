package com.maxxxwk.testtask.screens.catalog.presentation

import com.maxxxwk.android.text.UIText
import com.maxxxwk.testtask.screens.catalog.domain.Brand
import kotlinx.collections.immutable.ImmutableList

sealed interface CatalogScreenIntent {
    data class ShowBrands(val brands: ImmutableList<Brand>) : CatalogScreenIntent
    data class ShowError(val message: UIText) : CatalogScreenIntent
}
