package ru.ipixnix.lesson_jpc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

sealed class Screen(val rout: String) {
    data object Home: Screen("Home")
    data object Screen1: Screen("screen_1")
    data object Screen3: Screen("screen_3")
}

@Composable
fun Screen1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Экран 1",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.Screen3.rout) {
                    popUpTo(Screen.Screen3.rout) {
                        inclusive
                    }
                }
            }
        ) {
            Text(text = "Экран 3")
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Экран 2",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.Screen3.rout) {
                    popUpTo(Screen.Screen3.rout) {
                        inclusive
                    }
                }
            }
        ) {
            Text(text = "Экран 3")
        }
    }
}

@Composable
fun Screen3(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Экран 3",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.Home.rout) {
                    popUpTo(Screen.Home.rout) {
                        inclusive
                    }
                }
            }
        ) {
            Text(text = "Главная")
        }
    }
}
