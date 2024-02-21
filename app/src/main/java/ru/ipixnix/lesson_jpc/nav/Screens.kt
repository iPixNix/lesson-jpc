package ru.ipixnix.lesson_jpc.nav

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

sealed class NavScreen(val rout: String) {
    data object ScreenMain: NavScreen("Главный экран")
    data object Screen1: NavScreen("Экран 1")
    data object Screen2: NavScreen("Экран 2")
    data object Screen3: NavScreen("Экран 3")
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
                navController.navigate(NavScreen.Screen3.rout) {
                    popUpTo(NavScreen.Screen3.rout) {
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
                navController.navigate(NavScreen.Screen3.rout) {
                    popUpTo(NavScreen.Screen3.rout) {
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
                navController.navigate(NavScreen.ScreenMain.rout) {
                    popUpTo(NavScreen.ScreenMain.rout) {
                        inclusive
                    }
                }
            }
        ) {
            Text(text = "Главный")
        }
    }
}
