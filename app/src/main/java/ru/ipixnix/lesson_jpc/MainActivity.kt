package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Функция отрисовки Главного экрана
            ScreenMain()
        }
    }
}

// Параметр для автоматического отображения изменений
@Preview (showBackground = true)
// Функция Jetpack Compose Главный экран
@Composable
fun ScreenMain() {

    // Строка
    Column (
        // Модификаторы
        modifier = Modifier
                // Цвет фона
                .background(Color.Yellow)
                // Растянуть Строку на весь экран
                .fillMaxSize(),

                /* Расположение элементов по вертикали:
                 *
                 * Arrangement.SpaceBetween -
                 * крайние элементы прижимаются к краям родителя,
                 * оставшиеся выстраиваются внутри контейнера равномерно,
                 * так, чтобы между ними были одинаковые отступы.
                 *
                 * Arrangement.SpaceAround -
                 * свободное пространство делится поровну между элементами
                 * и по половине от этой доли размещается по бокам от каждого элемента.
                 * Таким образом, между соседними элементами будет равное расстояние,
                 * а снаружи крайних элементов — по половине этого расстояния.
                 *
                 * Arrangement.SpaceEvenly -
                 * свободное место будет распределено так,
                 * чтобы расстояние между любыми двумя элементами было одинаковым
                 * и расстояние от крайних элементов до края было таким же.
                 */
                verticalArrangement = Arrangement.SpaceEvenly,

                /* Выравнивание элементов по горизонтали:
                 * Alignment.Top - выравнивание сверху.
                 * Alignment.CenterVertically - выравнивание по центру.
                 * Alignment.Bottom - выравнивание снизу.
                 */
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Элемент Text 1
        Text(
            text = "Text 1" // Текст содержит слово "Text 1"
        )

        // Элемент Text 2
        Text(
            text = "Text 2" // Текст содержит слово "Text 2"
        )

        // Элемент Text 3
        Text(
            text = "Text 3" // Текст содержит слово "Text 3"
        )
    }
}