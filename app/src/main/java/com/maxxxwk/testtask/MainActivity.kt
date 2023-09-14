package com.maxxxwk.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.maxxxwk.init.api.InitScreenComponentHolder
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.testtask.navigation.Navigation
import com.maxxxwk.testtask.ui.theme.CutOnTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

class MainActivity : ComponentActivity() {

    private val initScreenDependencies by inject<InitScreenDependencies>()

    @KoinExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InitScreenComponentHolder.init(initScreenDependencies)
        setContent {
            CutOnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    KoinAndroidContext {
                        Navigation(closeApp = this::closeApp)
                    }
                }
            }
        }
    }

    private fun closeApp() {
        error("closed app") /* todo close app without error */
    }
}
