package com.maxxxwk.init.domain

internal class NetworkConnectionAvailabilityUseCase(
    private val networkStateRepository: NetworkStateRepository
) {
    operator fun invoke() =
        networkStateRepository.getCurrentNetworkState() == NetworkState.AVAILABLE
}
