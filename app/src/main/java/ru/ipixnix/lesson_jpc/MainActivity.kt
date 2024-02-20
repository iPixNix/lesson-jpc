package ru.ipixnix.lesson_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ru.ipixnix.lesson_jpc.ui.theme.LessonjpcTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* Применение темы к Главному экрану */
            LessonjpcTheme {/* Главный экран */

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.rout
                ) {
                    composable("Home") {
                        ScreenMain(navController = navController)
                    }
                    composable(Screen.Screen1.rout) {
                        Screen1(navController = navController)
                    }
                    composable(Screen.Screen3.rout) {
                        Screen3(navController = navController)
                    }
                }
            }
        }
    }
}


/** Главный экран */
@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenMain(navController: NavController) {

    /* Список элементов нижней панели навигации */
    val items = listOf(
        MenuItem(
            route = "Home",
            title = "Главная",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        MenuItem(
            route = "screen_1",
            title = "Чат",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.MailOutline,
            badgeCount = 45
        ),
        MenuItem(
            route = "screen_3",
            title = "Настройки",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
    )
    /* Верхняя панель навигации */
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        //ModalNavigationDrawer - выдвигается со щелью
        //DismissibleNavigationDrawer - выдвигается полностью
        ModalNavigationDrawer(
            drawerContent = {
                //ModalDrawerSheet - выдвигается со щелью
                //DismissibleDrawerSheet - выдвигается полностью
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            modifier = Modifier
                                    .padding(NavigationDrawerItemDefaults.ItemPadding),
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                navController.popBackStack()
                                navController.navigate(item.route) {
                                    popUpTo(item.route) {
                                        inclusive
                                    }
                                }
                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            badge = {
                                item.badgeCount?.let{
                                    Text(text = item.badgeCount.toString())
                                }
                            }
                        )
                    }
                }
            },
            drawerState = drawerState
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
                    LargeTopAppBar(
                        modifier = Modifier,
                        /*colors = centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                            actionIconContentColor = MaterialTheme.colorScheme.onSurface
                        ),*/
                        /* Заголовок */
                        title = {Text(text =  "Инструменты Material 3:\nПалитры приложения")},
                        /* Главная кнопка */
                        navigationIcon = {
                            /* Кнопка с иконкой */
                            IconButton(
                                /* Обработчик нажатия */
                                onClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            ) {
                                /* Иконка кнопки */
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Меню"
                                )
                            }
                        },
                        /* Дополнительные кнопки */
                        actions = {
                            /* Иконка кнопки */
                            IconButton(
                                /* Обработчик нажатия */
                                onClick = {
                                    /**TODO**/
                                }
                            ) {
                                /* Иконка кнопки */
                                Icon(
                                    imageVector = Icons.Default.Info, // Ссылка
                                    contentDescription = "Помощь" // Описание
                                )
                            }
                        },
                        /* Присвоить поведение прокрутки */
                        scrollBehavior = scrollBehavior
                    )
                },
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                /*colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.surface,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primary,
                                    unselectedIconColor = MaterialTheme.colorScheme.outline,
                                    unselectedTextColor = MaterialTheme.colorScheme.outline,
                                    disabledIconColor = MaterialTheme.colorScheme.outlineVariant,
                                    disabledTextColor = MaterialTheme.colorScheme.outlineVariant,
                                ),*/
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
                                                Badge(
                                                    /*containerColor = MaterialTheme.colorScheme
                                                            .tertiary,
                                                    contentColor = MaterialTheme.colorScheme
                                                            .surface*/
                                                )
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
                    /**.background(MaterialTheme.colorScheme.background) // Цвет фона**/
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
}
