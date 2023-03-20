package com.maxxxwk.testtask.screens.init.domain

interface NetworkStateRepository {
    fun getCurrentNetworkState(): NetworkState
}
