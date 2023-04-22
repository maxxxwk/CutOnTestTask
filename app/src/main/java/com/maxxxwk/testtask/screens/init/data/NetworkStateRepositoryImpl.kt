package com.maxxxwk.testtask.screens.init.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.maxxxwk.testtask.screens.init.domain.NetworkState
import com.maxxxwk.testtask.screens.init.domain.NetworkStateRepository
import javax.inject.Inject

class NetworkStateRepositoryImpl @Inject constructor(context: Context) : NetworkStateRepository {

    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun getCurrentNetworkState(): NetworkState {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork?.let {
                connectivityManager.getNetworkCapabilities(it)?.let { capabilities ->
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    ) NetworkState.AVAILABLE
                    else NetworkState.UNAVAILABLE
                }
            } ?: NetworkState.UNAVAILABLE
        } else {
            connectivityManager.activeNetworkInfo?.let {
                if (
                    it.isConnected &&
                    (it.type == ConnectivityManager.TYPE_WIFI || it.type == ConnectivityManager.TYPE_MOBILE)
                ) NetworkState.AVAILABLE
                else NetworkState.UNAVAILABLE
            } ?: NetworkState.UNAVAILABLE
        }
    }
}
