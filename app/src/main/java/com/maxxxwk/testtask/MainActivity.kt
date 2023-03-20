package com.maxxxwk.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.maxxxwk.testtask.common.viewmodel.ViewModelFactory
import com.maxxxwk.testtask.navigation.Navigation
import com.maxxxwk.testtask.navigation.NavigationRoute
import com.maxxxwk.testtask.network.auth.AuthTokenManager
import com.maxxxwk.testtask.ui.theme.CutOnTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var tokenManager: AuthTokenManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        setContent {
            CutOnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    Navigation(
                        startDestination = if (tokenManager.hasToken()) {
                            NavigationRoute.MAIN.route
                        } else {
                            NavigationRoute.INIT.route
                        },
                        viewModelFactory = viewModelFactory,
                        closeApp = { finishAndRemoveTask() }
                    )
                }
            }
        }
    }
}
