@file:Suppress("FunctionNaming")

package com.maxxxwk.testtask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.maxxxwk.auth.api.AuthScreenComponentHolder
import com.maxxxwk.auth.api.AuthScreenDependencies
import com.maxxxwk.catalog.api.CatalogScreenComponentHolder
import com.maxxxwk.catalog.api.CatalogScreenDependencies
import com.maxxxwk.home.api.HomeScreenComponentHolder
import com.maxxxwk.home.api.HomeScreenDependencies
import com.maxxxwk.init.api.InitScreenComponentHolder
import com.maxxxwk.logout.api.LogoutScreenComponentHolder
import com.maxxxwk.logout.api.LogoutScreenDependencies
import com.maxxxwk.testtask.ui.components.BottomNavigationBar
import javax.inject.Provider

@Suppress("LongMethod")
@Composable
fun Navigation(
    closeApp: () -> Unit,
    authScreenDependenciesProvider: Provider<AuthScreenDependencies>,
    logoutScreenDependenciesProvider: Provider<LogoutScreenDependencies>,
    homeScreenDependenciesProvider: Provider<HomeScreenDependencies>,
    catalogScreenDependenciesProvider: Provider<CatalogScreenDependencies>
) {
    val navController = rememberNavController()
    val bottomNavigationController = rememberBottomNavigationController(
        navController = navController,
        componentsInitializer = {
            when (it) {
                BottomNavigationRoute.HOME -> HomeScreenComponentHolder.init(
                    homeScreenDependenciesProvider.get()
                )
                BottomNavigationRoute.BRANDS_CATALOG -> CatalogScreenComponentHolder.init(
                    catalogScreenDependenciesProvider.get()
                )
                BottomNavigationRoute.COINS -> {}
                BottomNavigationRoute.CUSTOMER_SERVICE -> {}
                BottomNavigationRoute.SETTINGS -> {}
            }
        }
    )
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.INIT.route
    ) {
        composable(NavigationRoute.INIT.route) {
            ResetDependencies(InitScreenComponentHolder::reset)
            InitScreenComponentHolder.getApi().Screen(
                navigateToLoginScreen = {
                    navController.popBackStack()
                    AuthScreenComponentHolder.init(authScreenDependenciesProvider.get())
                    navController.navigate(NavigationRoute.LOGIN.route)
                },
                navigateToMainScreen = {
                    navController.popBackStack()
                    HomeScreenComponentHolder.init(homeScreenDependenciesProvider.get())
                    navController.navigate(NavigationRoute.MAIN.route)
                }
            )
        }
        composable(NavigationRoute.LOGIN.route) {
            ResetDependencies(AuthScreenComponentHolder::reset)
            AuthScreenComponentHolder.getApi().Screen(
                navigateToHomeScreen = {
                    navController.popBackStack()
                    HomeScreenComponentHolder.init(homeScreenDependenciesProvider.get())
                    navController.navigate(NavigationRoute.MAIN.route)
                }
            )
        }
        navigation(
            route = NavigationRoute.MAIN.route,
            startDestination = BottomNavigationRoute.HOME.route
        ) {
            composable(BottomNavigationRoute.HOME.route) {
                HomeScreenComponentHolder.getApi().Screen(
                    navigateToLogout = {
                        LogoutScreenComponentHolder.init(logoutScreenDependenciesProvider.get())
                        navController.navigate(NavigationRoute.LOGOUT.route)
                    },
                    navigateToCatalog = bottomNavigationController::navigateToBrandsCatalog,
                    bottomBar = {
                        BottomNavigationBar(
                            bottomNavigationController = bottomNavigationController,
                            backStackEntryState = navController.currentBackStackEntryAsState()
                        )
                    }
                )
            }
            composable(BottomNavigationRoute.BRANDS_CATALOG.route) {
                ResetDependencies(CatalogScreenComponentHolder::reset)
                CatalogScreenComponentHolder.getApi().Screen(
                    bottomBar = {
                        BottomNavigationBar(
                            bottomNavigationController = bottomNavigationController,
                            backStackEntryState = navController.currentBackStackEntryAsState()
                        )
                    }
                )
            }
            composable(BottomNavigationRoute.COINS.route) {}
            composable(BottomNavigationRoute.CUSTOMER_SERVICE.route) {}
            composable(BottomNavigationRoute.SETTINGS.route) {}
        }
        composable(NavigationRoute.LOGOUT.route) {
            ResetDependencies(LogoutScreenComponentHolder::reset)
            LogoutScreenComponentHolder.getApi().Screen(
                onBack = navController::popBackStack,
                closeApp = closeApp
            )
        }
    }
}

@Composable
private inline fun ResetDependencies(crossinline reset: () -> Unit) {
    DisposableEffect(Unit) { onDispose { reset() } }
}
