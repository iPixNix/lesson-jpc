package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Row (
        modifier = Modifier.background(Color.Yellow)
    ){
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