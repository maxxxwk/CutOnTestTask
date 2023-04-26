package com.maxxxwk.network.url

interface DynamicURLManager {
    fun saveURL(url: String)
    fun getURL(): String
}
