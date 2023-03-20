package com.maxxxwk.testtask.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.maxxxwk.testtask.navigation.BottomNavigationRoute
import com.maxxxwk.testtask.navigation.navigate

@Suppress("FunctionNaming")
@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        BottomNavigationRoute.values().forEach {
            val isSelected = currentRoute == it.route
            BottomNavigationItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Icon(painter = painterResource(it.iconRes), contentDescription = null)
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .size(3.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) MaterialTheme.colors.secondary
                                    else MaterialTheme.colors.background
                                )
                        )
                    }
                },
                selected = isSelected,
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
                onClick = { navController.navigate(bottomNavigationRoute = it) }
            )
        }
    }
}
