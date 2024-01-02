package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    // Элемент Text
    Text(
        text = "Hello" // Текст содержит слово "Hello"
    )
}