package com.maxxxwk.testtask.screens.catalog.presentation

import androidx.lifecycle.viewModelScope
import com.maxxxwk.android.text.UIText
import com.maxxxwk.android.viewmodel.BaseViewModel
import com.maxxxwk.android.R
import com.maxxxwk.testtask.screens.catalog.domain.BrandCatalogRepository
import javax.inject.Inject
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch

class CatalogScreenViewModel @Inject constructor(
    private val catalogRepository: BrandCatalogRepository
) : BaseViewModel<CatalogScreenState, CatalogScreenIntent>(CatalogScreenState.Loading) {

    init {
        loadBrands()
    }

    private fun loadBrands() = viewModelScope.launch {
        val result = catalogRepository.getBrandCatalog()
        result.getOrNull()?.let {
            intents.send(CatalogScreenIntent.ShowBrands(it.toImmutableList()))
        }
        result.exceptionOrNull()?.let {
            intents.send(CatalogScreenIntent.ShowError(UIText.StringResource(R.string.unknown_error)))
        }
    }

    override fun reduce(intent: CatalogScreenIntent): CatalogScreenState = when (intent) {
        is CatalogScreenIntent.ShowBrands -> CatalogScreenState.Content(intent.brands)
        is CatalogScreenIntent.ShowError -> CatalogScreenState.Error(intent.message)
    }
}
