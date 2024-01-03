package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /** Столбец */
            Column() {
                /** Список элементов списка */
                ListItem(
                    name = "Имя 1", // Имя из переменной функции
                    prof = "Профессия 1" // Профессия из переменной функции
                )
                ListItem(
                    name = "Имя 2",
                    prof = "Профессия 2"
                )
                ListItem(
                    name = "Имя 3",
                    prof = "Профессия 3"
                )
                ListItem(
                    name = "Имя 4",
                    prof = "Профессия 4"
                )
                ListItem(
                    name = "Имя 5",
                    prof = "Профессия 5"
                )
                ListItem(
                    name = "Имя 6",
                    prof = "Профессия 6"
                )
                ListItem(
                    name = "Имя 7",
                    prof = "Профессия 7"
                )
                ListItem(
                    name = "Имя 8",
                    prof = "Профессия 8"
                )
                ListItem(
                    name = "Имя 9",
                    prof = "Профессия 9"
                )
            }
        }
    }
}

@Composable
fun ListItem(name: String, prof: String) {

    /** Карточка */
    Card(
        modifier = Modifier
                .fillMaxWidth() // Растянуть во всю ширину экрана
                .padding(10.dp), // Поля
        /* Форма - прямоугольник с закруглёнными углами */
        shape = RoundedCornerShape(15.dp),
        /* Поднятие карточки над поверхностью */
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        /** Блок */
        Box(
            modifier = Modifier
                    .fillMaxWidth() // Растянуть во всю ширину экрана
                    .background(Color.Green) // Цвет фона
        ) {
            /** Строка */
            Row(
                modifier = Modifier
                        .background(Color.Yellow), // Цвет фона
                        /* Выравнивание по центру вертикали */
                        verticalAlignment = Alignment.CenterVertically
            ) {
                /** Изображение */
                Image(
                    modifier = Modifier
                            .size(64.dp) // Размер
                            .padding(5.dp) // Поля
                            .clip(CircleShape), // Форма - круг
                    /* Ссылка на изоюражение */
                    painter = painterResource(id = R.drawable.ipixnix),
                    /* Описание */
                    contentDescription = "iPixNix",
                    /* Способ обрезки */
                    contentScale = ContentScale.Crop
                )
                /** Столбец */
                Column(
                    modifier = Modifier

                            /* Вначале устанавливаем поле справа
                             * (до изменения цвета фона),
                             * чтобы поле справа не окрасилось в цвет фона
                             */
                            .padding(end = 16.dp)

                            /* Затем изменяем цвет фона */
                            .background(Color.Red)

                            /* Устанавливаем поле слева
                             * (после изменения цвета фона),
                             * чтобы поле слева окрасилось в цвет фона
                             */
                            .padding(start = 16.dp)
                ) {
                    /** Список текстовых строк */
                    Text(
                        text = name // Имя из переменной функции
                    )
                    Text(
                        text = prof // Профессия из переменной функции
                    )
                }
            }
        }
    }

}