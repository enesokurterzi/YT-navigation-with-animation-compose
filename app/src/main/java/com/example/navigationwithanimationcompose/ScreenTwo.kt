package com.example.navigationwithanimationcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenTwo(navController: NavController, name: String, surname: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(text = "Screen Two", color = Color.White)
        Text(text = "Name: $name\nSurname: $surname", color = Color.White)
        Button(onClick = { navController.navigate(Screen.ScreenThree(title = "Android developer")) }) {
            Text(text = "Go To Screen Three")
        }
    }

}