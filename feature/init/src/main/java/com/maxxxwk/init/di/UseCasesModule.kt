package com.maxxxwk.init.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.maxxxwk.init.domain.NetworkConnectionAvailabilityUseCase

internal val useCasesModule = module {
    factoryOf(::NetworkConnectionAvailabilityUseCase)
}
