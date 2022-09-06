package com.example.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(vertical = 15.dp)
            .defaultMinSize(minHeight = 160.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Header", fontWeight = FontWeight.Bold, fontSize = 34.sp,
            color = MaterialTheme
                .colors.onPrimary,
        )
    }
}

@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem>,
    onClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(menuItems) { item ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        onClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = "",
                    modifier = modifier.size(24.dp)
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(text = item.title)
            }
        }
    }
}