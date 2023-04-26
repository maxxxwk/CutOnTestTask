package com.maxxxwk.init.domain

internal interface NetworkStateRepository {
    fun getCurrentNetworkState(): NetworkState
}
