package com.maxxxwk.local_preferences.api

import android.content.Context
import com.maxxxwk.kotlin.api.Dependencies
import com.maxxxwk.kotlin.dispatchers.DispatchersProvider

interface LocalPreferencesDependencies : Dependencies {
    val dispatchersProvider: DispatchersProvider
    val context: Context
}
