package ru.ipixnix.lesson_jpc.bottom_navigation

import ru.ipixnix.lesson_jpc.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {

    /* Экран 1 */
    data object Screen1: BottomItem("Экран 1", R.drawable.ic_android, "Scr1")
    /* Экран 2 */
    data object Screen2: BottomItem("Экран 2", R.drawable.ic_android, "Scr2")
    /* Экран 3 */
    data object Screen3: BottomItem("Экран 3", R.drawable.ic_android, "Scr3")
    /* Экран 4 */
    data object Screen4: BottomItem("Экран 4", R.drawable.ic_android, "Scr4")

}