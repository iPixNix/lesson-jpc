package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    /* Ленивая Колонка */
    LazyColumn(
        /* Выравнивание по горизонтали */
        horizontalAlignment = Alignment.CenterHorizontally,
        /* Модификаторы */
        modifier = Modifier
                .fillMaxSize() // Растянуть по размеру Родителя
    ) {
        /* Динамический список (может содержать разное количество элементов) */
        itemsIndexed(
            /* Список из пяти элементов */
            listOf("Первый", "Второй", "Третий", "Четвёртый", "Пятый")
        ) {
            /* Индекс списка (index), содержимое элемента (item).
             * Если index или item не используется в коде,
             * необходимо указать вместо него нижнее подчёркивание (_).
             * Например: "_, item ->" или "index, _ ->" */
            index, item ->
            /* В каждом элементе списка Индекс + Текст */
            Text(
                text = "$index - $item", // Индекс и содержимое элемента
                fontSize = 32.sp, // Размер текста
                /* Модификаторы */
                modifier = Modifier
                        /* Поля: сверху и снизу */
                        .padding(vertical = 10.dp)
            )
        }
    }
}