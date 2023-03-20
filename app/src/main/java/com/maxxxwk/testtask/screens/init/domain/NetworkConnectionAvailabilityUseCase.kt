package com.maxxxwk.testtask.screens.init.domain

import javax.inject.Inject

class NetworkConnectionAvailabilityUseCase @Inject constructor(
    private val networkStateRepository: NetworkStateRepository
) {
    operator fun invoke(): Boolean {
        return networkStateRepository.getCurrentNetworkState() == NetworkState.AVAILABLE
    }
}
