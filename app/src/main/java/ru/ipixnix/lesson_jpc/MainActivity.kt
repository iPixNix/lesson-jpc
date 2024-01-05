package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
        /* Список содержит 100 элементов */
        items(100) {
            /* Каждый элемент списка содержит Текст */
            Text(
                text = "Текст $it", // Текст + Индекс элемента
                fontSize = 32.sp, // Размер текста
                /* Модификаторы */
                modifier = Modifier
                        /* Поля: сверху и снизу */
                        .padding(vertical = 10.dp)
            )
        }
    }
}