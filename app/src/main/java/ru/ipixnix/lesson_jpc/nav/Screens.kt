package ru.ipixnix.lesson_jpc.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.ipixnix.lesson_jpc.ScreenMain

sealed class NavScreen(val rout: String) {
    data object ScreenMain: NavScreen("Главный экран")
    data object Screen1: NavScreen("Экран 1")
    data object Screen2: NavScreen("Экран 2")
    data object Screen3: NavScreen("Экран 3")
}

@Composable
fun NavScreens() {
    /* Контроллер навигации */
    val navController = rememberNavController()
    /* Навигационный узел */
    NavHost(
        navController = navController, // Контроллер навигации
        startDestination = NavScreen.ScreenMain.rout // Стартовый экран
    ) {
        /* Экран Home (Главный экран) */
        composable(NavScreen.ScreenMain.rout) {
            /* Структура экрана Home */
            ScreenMain(navController = navController)
        }
        /* Экран Screen1 (Экран 1) */
        composable(NavScreen.Screen1.rout) {
            /* Структура экрана Screen1 */
            Screen1(navController = navController)
        }
        /* Экран Screen1 (Экран 3) */
        composable(NavScreen.Screen3.rout) {
            /* Структура экрана Screen3 */
            Screen3(navController = navController)
        }
    }
}