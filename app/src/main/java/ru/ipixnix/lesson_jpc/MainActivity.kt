package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* Главный экран */
            ScreenMain()
        }
    }
}

/** Главный экран */
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenMain() {
    /* Ленивый Ряд */
    LazyRow(
        /* Модификаторы */
        modifier = Modifier
                .fillMaxWidth() // Растянуть по ширине Родителя
                .background(Color.LightGray) // Цвет фона
    ) {
        /* Динамический список (может содержать разное количество элементов) */
        itemsIndexed(
            listOf( // Список из элементов пользовательского типа ItemRowModel
                ItemRowModel(R.drawable.ipixnix, "iPixNix 1"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 2"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 3"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 4"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 5"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 6"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 7"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 8"),
                ItemRowModel(R.drawable.ipixnix, "iPixNix 9")
            )
        ) {
            /* Индекс списка (index), содержимое элемента (item).
             * Если index или item не используется в коде,
             * необходимо указать вместо него нижнее подчёркивание (_).
             * Например: "_, item ->" или "index, _ ->" */
            _, item ->
            /* В каждом элементе списка Класс данных (Data Class) */
            ItemRow(item = item)
        }
    }
}