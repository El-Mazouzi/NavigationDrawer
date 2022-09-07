package com.example.navigationdrawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    val users = listOf("one", "two", "three", "four", "five", "six")

    var search by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        TextField(
            value = search,
            onValueChange = {
                search = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        val filteredList = mutableListOf<String>()

        users.forEach { item ->
            if (item.contains(search.text)) {
                filteredList.add(item)
            }
        }
        if (filteredList.isNotEmpty()) {

            LazyColumn(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
            ) {


                items(filteredList.size) { item ->
                    Text(
                        text = filteredList[item],
                        color = Color.DarkGray,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }

            }
        } else {
            Text(
                text = "No Result Found !!",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
