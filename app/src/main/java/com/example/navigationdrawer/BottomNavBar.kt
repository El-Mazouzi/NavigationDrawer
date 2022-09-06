package com.example.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val items = listOf(
        Routes.Home,
        Routes.Cart,
        Routes.Profile,
    )
    BottomAppBar(
        backgroundColor = Color.White,
        elevation = 16.dp,
        modifier = modifier.fillMaxWidth(),
        content = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = "",
                                tint = if (currentRoute == item.route) MaterialTheme.colors.primary else Color.LightGray
                            )
                            if (currentRoute == item.route)
                                Text(
                                    text = item.title,
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colors.primary
                                )

                        }
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    )
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen()
        }
        composable(Routes.Cart.route) {
            CartScreen()
        }
        composable(Routes.Profile.route) {
            ProfileScreen()
        }
    }
}
