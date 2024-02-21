package ru.ipixnix.lesson_jpc.nav

import androidx.compose.ui.graphics.vector.ImageVector

/** Структура пунктов меню **/
data class MenuItem(
    val route: String, // Путь к вызываемому экрану
    val title: String, // Заголовок пунка меню
    val selectedIcon: ImageVector, // Иконка выбранного пункта меню
    val unselectedIcon: ImageVector, // Иконка невыбранного пункта меню
    val hasNews: Boolean = false, // Есть ли новости (значок)
    val badgeCount: Int? = null // Количество новостей (значок со счётчиком)
)
