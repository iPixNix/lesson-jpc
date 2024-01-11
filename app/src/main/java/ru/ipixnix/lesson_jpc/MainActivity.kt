package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import ru.ipixnix.lesson_jpc.ui.theme.LessonjpcTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* Применение темы к Главному экрану */
            LessonjpcTheme {/* Главный экран */
                ScreenMain()
            }
        }
    }
}

/** Главный экран */
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenMain() {
    /* Список элементов нижней панели навигации */
    val items = listOf(
        BottomNavigationItem(
            title = "Главная",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Чат",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.MailOutline,
            hasNews = false,
            badgeCount = 45
        ),
        BottomNavigationItem(
            title = "Настройки",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = true
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    /* Верхняя панель навигации */
     Surface(
         modifier = Modifier
                 .fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
         /* Привязанная панель */
         //val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

         //val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
         /* Прятать панель навигации при прокрутке вниз
         *  и показывать при прокрутке вверх */
         //val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

         /* Сворачивать панель навигации при прокрутке вниз
         *  и разворачивать при прокрутке вверх */
         //val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

         /* Поведение панели навигации */
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

         /* Область панели навигации */
        Scaffold(
            /* Модификаторы */
            modifier = Modifier
                    .fillMaxSize() // Растянуть по ширине Родителя
                    /* Привязать поведение к вложенной прокрутке */
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                /* Верхняя панель навигации
                 * TopAppBar - стандартная панель навигации
                 * CenterAlignedTopAppBar - панель навигации с заголовком по центру
                 * MediumTopAppBar - панель навигации с заголовком под меню
                 * LargeTopAppBar - панель навигации с заголовком под меню
                 * и дополнительной строкой перед заголовком */
                CenterAlignedTopAppBar(
                    modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary),
                    colors = centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    /* Заголовок */
                    title = {
                        /* Текст заголовка */
                        Text(text =  "iPixNix")
                    },
                    /* Главная кнопка */
                    navigationIcon = {
                        /* Кнопка с иконкой */
                        IconButton(
                            /* Обработчик нажатия */
                            onClick = {
                                /*TODO*/
                            }
                        ) {
                            /* Иконка кнопки */
                            Icon(
                                imageVector = Icons.Default.Menu, // Ссылка
                                contentDescription = "Меню" // Описание
                            )
                        }
                    },
                    /* Дополнительные кнопки */
                    actions = {
                        /* Кнопка с иконкой */
                        IconButton(
                            /* Обработчик нажатия */
                            onClick = {
                                /*TODO*/
                            }
                        ) {
                            /* Иконка кнопки */
                            Icon(
                                imageVector = Icons.Default.Add, // Ссылка
                                contentDescription = "Добавить" // Описание
                            )
                        }
                        /* Иконка кнопки */
                        IconButton(
                            /* Обработчик нажатия */
                            onClick = {
                                /*TODO*/
                            }
                        ) {
                            /* Иконка кнопки */
                            Icon(
                                imageVector = Icons.Default.Settings, // Ссылка
                                contentDescription = "Настройки" // Описание
                            )
                        }
                    },
                    /* Присвоить поведение прокрутки */
                    scrollBehavior = scrollBehavior
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                                indicatorColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                                disabledIconColor = MaterialTheme.colorScheme.secondary,
                                disabledTextColor = MaterialTheme.colorScheme.secondary,
                            ),
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                //navController.navigate(item.title)
                            },
                            label = {
                                    Text(text = item.title)
                            },
                            alwaysShowLabel = true,
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if ( item.badgeCount != null ) {
                                            Badge {
                                                Text( text = item.badgeCount.toString())
                                            }
                                        } else if ( item.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if ( index == selectedItemIndex ) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
                }
            }
        ) {
            /* Содержимое ниже панели навигации */
            values ->
            /* Ленивая Колонка */
            LazyColumn(
                /* Модификаторы */
                modifier = Modifier
                        .fillMaxWidth() // Растянуть по ширине Родителя
                        .padding(values) // Поля
                        .background(MaterialTheme.colorScheme.background) // Цвет фона
            ) {
                /* Динамический список (может содержать разное количество элементов) */
                itemsIndexed(
                    listOf( // Список из элементов пользовательского типа ItemRowModel
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 1",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 2",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 3",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 4",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 5",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 6",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 7",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 8",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 9",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 10",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 11",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 12",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 13",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 14",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        ),
                        ItemRowModel(
                            R.drawable.ipixnix, "iPixNix 15",
                            "Противоположная точка зрения подразумевает, что некоторые особенности внутренней политики набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Вот вам яркий пример современных тенденций — постоянный количественный рост и сфера нашей активности способствует подготовке и реализации существующих финансовых и административных условий. Значимость этих проблем настолько очевидна, что разбавленное изрядной долей эмпатии, рациональное мышление влечет за собой процесс внедрения и модернизации благоприятных перспектив."
                        )
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
    }
}
