package com.maxxxwk.init.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.maxxxwk.init.domain.NetworkState
import com.maxxxwk.init.domain.NetworkStateRepository

internal class NetworkStateRepositoryImpl(context: Context) : NetworkStateRepository {

    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Suppress("NestedBlockDepth", "DEPRECATION")
    override fun getCurrentNetworkState(): NetworkState =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
