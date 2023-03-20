package com.maxxxwk.testtask.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherMain

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherIO

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherDefault

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherUnconfined
