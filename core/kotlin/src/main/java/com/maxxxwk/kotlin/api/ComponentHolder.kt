package com.maxxxwk.kotlin.api

interface ComponentHolder<DEPENDENCIES, API> {
    fun init(dependencies: DEPENDENCIES)
    fun getApi(): API
    fun reset()
}
