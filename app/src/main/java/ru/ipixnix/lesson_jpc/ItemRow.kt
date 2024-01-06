package ru.ipixnix.lesson_jpc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/** Шаблон для элемента Горизонтального списка */
@Composable
fun ItemRow(item: ItemRowModel) {
    /* Колонка */
    Column(
        /* Горизонтальное выравнивание по центру */
        horizontalAlignment = Alignment.CenterHorizontally,
        /* Модификаторы */
        modifier = Modifier
                .padding(3.dp) // Поля
                .background(Color.White) // Белый фон
    ) {
        /* Изображение элемента */
        Image(
            /* Идентификатор изображения */
            painter = painterResource(id = item.imageId),
            /* Описание изображения */
            contentDescription = "image",
            /* Способ маштабирования изображения */
            contentScale = ContentScale.Crop,
            /* Модификаторы */
            modifier = Modifier
                    .padding(4.dp) // Поля
                    .size(64.dp) // Размер
                    .clip(CircleShape) // Форма
        )
        /* Текст элемента */
        Text(text = item.title)
    }
}