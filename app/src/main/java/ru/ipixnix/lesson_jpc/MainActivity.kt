package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

    // Родительский контейнер (Строка)
    Row (
        // Модификаторы
        modifier = Modifier
                // Цвет фона Жёлтый
                .background(Color.Yellow)
                // Растянуть Строку по ширине на весь экран
                .fillMaxWidth()
                // Растянуть Строку по высоте на весь экран
                .fillMaxHeight()
    ) {
        // Столбец 1
        Column (
            // Модификаторы
            modifier = Modifier
                    // Цвет фона Красный
                    .background(Color.Red)
                    // Растянуть Столбец по ширине на 50% от Родительского контейнера
                    .fillMaxWidth(0.5f)
                    // Растянуть Столбец по высоте на весь Родительский контейнер
                    .fillMaxHeight(),

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
            // Элемент Текст 1.1
            Text(
                text = "Текст 1.1" // Текст содержит слово "Текст 1.1
            )

            // Элемент Текст 1.2
            Text(
                text = "Текст 1.2" // Текст содержит слово "Текст 1.2"
            )

            // Элемент Текст 1.3
            Text(
                text = "Текст 1.3" // Текст содержит слово "Текст 1.3"
            )
        }
        // Столбец 2
        Column (
            // Модификаторы
            modifier = Modifier
                    // Цвет фона Зелёный
                    .background(Color.Green)
                    // Занять по ширине 50% от оставшегося места
                    .fillMaxWidth(0.5f)
                    // Растянуть Столбец по высоте на 80% от Родительского контейнера
                    .fillMaxHeight(0.8f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Элемент Текст 2.1
            Text(
                text = "Текст 2.1" // Текст содержит слово "Текст 2.1"
            )

            // Элемент Текст 2.2
            Text(
                text = "Текст 2.2" // Текст содержит слово "Текст 2.2"
            )

            // Элемент Текст 2.3
            Text(
                text = "Текст 2.3" // Текст содержит слово "Текст 2.3"
            )
        }
    }
}