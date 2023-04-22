package com.maxxxwk.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

typealias ViewModelsProviders = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

class ViewModelFactory constructor(
    private val providers: ViewModelsProviders
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = providers[modelClass]?.get() as T
}
