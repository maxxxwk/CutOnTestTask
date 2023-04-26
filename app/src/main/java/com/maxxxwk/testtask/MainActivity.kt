package com.maxxxwk.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.maxxxwk.auth.api.AuthScreenDependencies
import com.maxxxwk.catalog.api.CatalogScreenDependencies
import com.maxxxwk.home.api.HomeScreenDependencies
import com.maxxxwk.init.api.InitScreenComponentHolder
import com.maxxxwk.init.api.InitScreenDependencies
import com.maxxxwk.logout.api.LogoutScreenDependencies
import com.maxxxwk.testtask.navigation.Navigation
import com.maxxxwk.testtask.ui.theme.CutOnTheme
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var initScreenDependenciesProvider: Provider<InitScreenDependencies>

    @Inject
    lateinit var authScreenDependenciesProvider: Provider<AuthScreenDependencies>

    @Inject
    lateinit var logoutScreenDependenciesProvider: Provider<LogoutScreenDependencies>

    @Inject
    lateinit var homeScreenDependenciesProvider: Provider<HomeScreenDependencies>

    @Inject
    lateinit var catalogScreenDependenciesProvider: Provider<CatalogScreenDependencies>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        InitScreenComponentHolder.init(initScreenDependenciesProvider.get())
        setContent {
            CutOnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    Navigation(
                        closeApp = { error("closed app") /* todo close app without error */ },
                        authScreenDependenciesProvider = authScreenDependenciesProvider,
                        logoutScreenDependenciesProvider = logoutScreenDependenciesProvider,
                        homeScreenDependenciesProvider = homeScreenDependenciesProvider,
                        catalogScreenDependenciesProvider = catalogScreenDependenciesProvider
                    )
                }
            }
        }
    }
}
