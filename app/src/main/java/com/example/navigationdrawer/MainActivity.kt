package com.example.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val scaffoldState = rememberBottomSheetScaffoldState()
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                BottomSheetScaffold(
                    topBar = {
                        AppBar(
                            onAppBarClicked = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    scaffoldState = scaffoldState,
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            menuItems = listOf(
                                MenuItem(index = 0, title = "Home", icon = Icons.Default.Home),
                                MenuItem(
                                    index = 1,
                                    title = "Settings",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem(index = 2, title = "Help", icon = Icons.Default.Info),
                            ),
                            onClick = {
                                println("${it.title} Clicked !!!")
                            },
                        )
                    },
                    sheetElevation = 18.dp,
                    sheetPeekHeight = 0.dp,
                    sheetContent = { BottomSheet(scaffoldState = scaffoldState) }
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(
                                navController = navController
                            )
                        },
                    ) {

                        NavigationGraph(
                            navController = navController,
                            scaffoldState = scaffoldState
                        )
                    }
                }
            }
        }
    }
}
