package com.maxxxwk.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.maxxxwk.auth.api.AuthScreenComponentHolder
import com.maxxxwk.auth.api.AuthScreenDependencies
import com.maxxxwk.home.api.HomeScreenComponentHolder
import com.maxxxwk.home.api.HomeScreenDependencies
import com.maxxxwk.init.api.InitScreenComponentHolder
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.logout.api.LogoutScreenComponentHolder
import com.maxxxwk.logout.api.LogoutScreenDependencies
import com.maxxxwk.testtask.navigation.Navigation
import com.maxxxwk.testtask.ui.theme.CutOnTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var initScreenDependencies: InitScreenDependencies

    @Inject
    lateinit var authScreenDependencies: AuthScreenDependencies

    @Inject
    lateinit var logoutScreenDependencies: LogoutScreenDependencies

    @Inject
    lateinit var homeScreenDependencies: HomeScreenDependencies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        InitScreenComponentHolder.init(initScreenDependencies)
        AuthScreenComponentHolder.init(authScreenDependencies)
        LogoutScreenComponentHolder.init(logoutScreenDependencies)
        HomeScreenComponentHolder.init(homeScreenDependencies)
        setContent {
            CutOnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    Navigation(
                        viewModelFactory = viewModelFactory,
                        closeApp = { error("closed app") /* todo close app without error */ }
                    )
                }
            }
        }
    }
}
