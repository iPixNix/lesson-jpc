package ru.ipixnix.lesson_jpc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/** androidx.compose.runtime.getValue и androidx.compose.runtime.setValue
 * Необходимы для того, чтобы не писать: isExpanded.value = ...
 * Вместо этого можно написать как для обычной переменной: isExpanded = ...
 */

/** Шаблон для элемента Горизонтального списка */
@Composable
fun ItemRow(item: ItemRowModel) {
    /* Состояние контента (Свёрнут/Развёрнут) */
    var isExpanded by remember { mutableStateOf(false) }

    /* Ряд */
    Row(
        /* Горизонтальное выравнивание по центру */
        /* Модификаторы */
        modifier = Modifier
                .padding(3.dp) // Поля
                .fillMaxWidth() // Растянуть по ширине Родителя
                .background(MaterialTheme.colorScheme.surfaceTint) // Белый фон
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
        /* Колонка */
        Column(
            /* Модификаторы */
            modifier = Modifier
                    /* Поля слева и сверху - 8dp */
                    .padding(start = 8.dp, top = 8.dp)
        ) {
            /* Текст элемента */
            Text(
                color = MaterialTheme.colorScheme.primary,
                text = item.title)
            /* Контент элемента */
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                /* Модификаторы */
                modifier = Modifier
                        /* Обработчик нажатия */
                        .clickable {
                            /* Меняет значение
                             * Свёрнуто/Развёрнуто
                             * на противоположное */
                            isExpanded = !isExpanded
                        },
                /* Максимальное количество строк.
                * Если значение Развёрнуто - максимальное количество строк,
                * а если значение Свёрнуто - одна строка */
                maxLines = if(isExpanded) Int.MAX_VALUE else 1,
                /* Содержимое контента элемента */
                text = item.content
            )
        }
    }
}