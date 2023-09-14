package com.maxxxwk.kotlin.api

interface ComponentHolder<DEPENDENCIES : Dependencies, API : Api> {
    fun init(dependencies: DEPENDENCIES)
    fun getApi(): API
    fun reset()
}

interface Dependencies

interface Api
