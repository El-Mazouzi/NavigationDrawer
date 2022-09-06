package com.example.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Routes(
    var index: Int,
    var title: String,
    var icon: ImageVector,
    var route: String
) {

    object Home : Routes(index = 0, title = "Home", icon = Icons.Default.Home, route = "Home")

    object Cart : Routes(
        index = 1,
        title = "Cart",
        icon = Icons.Default.ShoppingCart,
        route = "Cart"
    )

    object Profile :
        Routes(
            index = 2, title = "Profile", icon = Icons.Default.Person, route = "Profile"
        )
}
