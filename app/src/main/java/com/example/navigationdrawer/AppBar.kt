package com.example.navigationdrawer

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable

@Composable
fun AppBar(
    onAppBarClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Home Screen")
        },
        contentColor = MaterialTheme.colors.onPrimary,
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { onAppBarClicked() }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
        }
    )
}
