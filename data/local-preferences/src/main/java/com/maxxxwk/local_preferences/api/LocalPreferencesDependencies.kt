package com.maxxxwk.local_preferences.api

import android.content.Context
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider

interface LocalPreferencesDependencies {
    val dispatchersProvider: DispatchersProvider
    val context: Context
}
