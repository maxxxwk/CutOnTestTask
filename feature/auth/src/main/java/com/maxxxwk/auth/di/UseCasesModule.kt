package com.maxxxwk.auth.di

import com.maxxxwk.auth.domain.AuthUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCasesModule = module {
    factoryOf(::AuthUseCase)
}
