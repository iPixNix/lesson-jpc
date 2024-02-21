package ru.ipixnix.lesson_jpc.nav

sealed class NavScreen(val rout: String) {
    data object ScreenMain: NavScreen("Главный экран")
    data object Screen1: NavScreen("Экран 1")
    data object Screen2: NavScreen("Экран 2")
    data object Screen3: NavScreen("Экран 3")
}
