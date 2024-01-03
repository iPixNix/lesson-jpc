package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /** Столбец */
            Column(
                modifier = Modifier
                        /* Добавить вертикальную прокрутку для списка */
                        .verticalScroll(rememberScrollState())
            ) {
                /** Список элементов списка */
                ListItem(
                    name = "Имя ", // Имя из переменной функции
                    prof = "Профессия " // Профессия из переменной функции
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
                ListItem(
                    name = "Имя ",
                    prof = "Профессия "
                )
            }
        }
    }
}

@Composable
fun ListItem(name: String, prof: String) {
    /** Состояние счётчика */
    val counter = remember {
        mutableIntStateOf(0)
    }
    /** Состояние Цвета 1 */
    val color1 = remember {
        mutableStateOf(Color.Green)
    }
    /** Состояние Цвета 2 */
    val color2 = remember {
        mutableStateOf(Color.Yellow)
    }
    /** Состояние Цвета 3 */
    val color3 = remember {
        mutableStateOf(Color.Red)
    }

    /** Карточка */
    Card(
        modifier = Modifier
                .fillMaxWidth() // Растянуть во всю ширину экрана
                .padding(10.dp) // Поля
                .clickable { // Обработчик клика
                    /* Проверить состояние счётчика */
                    when(++counter.intValue) {
                        1 -> { // Если равен 1
                            color1.value = Color.Blue // Сделать фон Блока синим (Box)
                            color2.value = Color.Green // Сделать фон Строки зелёным (Row)
                            color3.value = Color.Yellow // Сделать фон Столбца жёлтым (Column)
                        }
                        2 -> { // Если равен 2
                            color1.value = Color.Magenta // Сделать фон Блока сиреневым (Box)
                            color2.value = Color.Blue // Сделать фон Строки синим (Row)
                            color3.value = Color.Green // Сделать фон Столбца зелёным (Column)
                        }
                        3 -> { // Если равен 3
                            color1.value = Color.Red // Сделать фон Блока красным (Box)
                            color2.value = Color.Magenta // Сделать фон Строки сиреневым (Row)
                            color3.value = Color.Blue // Сделать фон Столбца синим (Column)
                        }
                        4 -> { // Если равен 4
                            color1.value = Color.Yellow // Сделать фон Блока жёлтым (Box)
                            color2.value = Color.Red // Сделать фон Строки красным (Row)
                            color3.value = Color.Magenta // Сделать фон Столбца сиреневым (Column)
                        }
                        5 -> { // Если равен 5
                            color1.value = Color.Green // Сделать фон Блока зелёным (Box)
                            color2.value = Color.Yellow // Сделать фон Строки жёлтым (Row)
                            color3.value = Color.Red // Сделать фон Столбца красным (Column)
                            counter.intValue = 0
                        }
                    }
                },
        /* Форма - прямоугольник с закруглёнными углами */
        shape = RoundedCornerShape(15.dp),
        /* Поднятие карточки над поверхностью */
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        /** Блок */
        Box(
            modifier = Modifier
                    .fillMaxWidth() // Растянуть во всю ширину экрана
                    .background(color1.value) // Цвет фона
        ) {
            /** Строка */
            Row(
                modifier = Modifier
                        .background(color2.value), // Цвет фона
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
                            .background(color3.value)

                            /* Устанавливаем поле слева
                             * (после изменения цвета фона),
                             * чтобы поле слева окрасилось в цвет фона
                             */
                            .padding(start = 16.dp)
                ) {
                    /** Список текстовых строк */
                    Text(
                        /* Имя из переменной функции + знаяение счётчика */
                        text = name + counter.intValue.toString()
                    )
                    Text(
                        /* Профессия из переменной функции + знаяение счётчика */
                        text = prof + counter.intValue.toString()
                    )
                }
            }
        }
    }

}