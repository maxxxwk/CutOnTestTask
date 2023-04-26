package com.maxxxwk.init.domain

import javax.inject.Inject

internal class NetworkConnectionAvailabilityUseCase @Inject constructor(
    private val networkStateRepository: NetworkStateRepository
) {
    operator fun invoke() =
        networkStateRepository.getCurrentNetworkState() == NetworkState.AVAILABLE
}
