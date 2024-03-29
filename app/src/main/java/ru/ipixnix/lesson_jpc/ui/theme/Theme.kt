package ru.ipixnix.lesson_jpc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Цветовая схема содержит все именованные параметры цвета для MaterialTheme.
 *
 * Цветовые схемы разработаны так, чтобы быть гармоничными, обеспечивать доступность текста
 * и отличать элементы и поверхности пользовательского интерфейса друг от друга.
 * Существует две встроенные базовые схемы: LightColorScheme и DarkColorScheme,
 * которые можно использовать как есть или настраивать.
 *
 * Цветовая система Material и пользовательские схемы предоставляют значения цвета по умолчанию
 * в качестве отправной точки для настройки.
 *
 * Дополнительные сведения о цветах см. в разделе цвета Material Design.
 *
 * ===================
 * || ГЛАВНЫЕ ЦВЕТА ||
 * ===================
 *
 * @ primary — Первичный цвет. Это цвет, который чаще всего отображается на экранах и в
 * компонентах вашего приложения.
 *
 * @ onPrimary — Цвет используемый для текста и значков, отображаемых поверх первичного цвета.
 *
 * @ secondary — Вторичный цвет дает больше возможностей подчеркнуть и выделить ваш продукт.
 * Вторичные цвета лучше всего подходят для:
 *      • Плавающие кнопки действий.
 *      • Элементы управления выбором, такие как флажки и переключатели.
 *      • Выделение выбранного текста
 *      • Ссылки и заголовки
 *
 * @ onSecondary — Цвет используемый для текста и значков, отображаемых поверх вторичного цвета.
 *
 * @ tertiary — Третичный цвет можно использовать для баланса основных и вторичных цветов
 * или для привлечения повышенного внимания к такому элементу, как поле ввода.
 *
 * @ onTertiary — Цвет используемый для текста и значков, отображаемых поверх третичного цвета.
 *
 * @ inversePrimary — Цвет, который будет использоваться в качестве первичного цвета в местах,
 * где необходима инверсная цветовая схема, например, кнопка на SnackBar.
 *
 * ==========================
 * || ДОПОЛНИТЕЛЬНЫЕ ЦВЕТА ||
 * ==========================
 *
 * @ background — Цвет фона, который появляется за прокручиваемым содержимым.
 *
 * @ onBackground — Цвет используемый для текста и значков, отображаемых поверх цвета фона.
 *
 * @ error — Цвет ошибки используется для обозначения ошибок в компонентах, например
 * недопустимого текста в текстовом поле.
 *
 * @ onError — Цвет используемый для текста и значков, отображаемых поверх цвета ошибки.
 *
 * @ outline — Цвет, используемый для границ декоративных элементов.
 *
 * @ outlineVariant — Вариант цвета границ элементов, когда не требуется сильный контраст.
 *
 * @ scrim — Цвет холста, скрывающего содержимое.
 *
 * ================
 * || КОНТЕЙНЕРЫ ||
 * ================
 *
 * @ primaryContainer — Цвет первичных контейнеров.
 *
 * @ onPrimaryContainer — Цвет содержимого, которое отображается поверх первичного контейнера.
 *
 * @ secondaryContainer — Цвет вторичных контейнеров
 * (выделенные пункты нижней и боковой панелей).
 *
 * @ onSecondaryContainer — Цвет содержимого, которое отображается поверх вторичного контейнера.
 *
 * @ tertiaryContainer — Цвет третичных контейнеров.
 *
 * @ onTertiaryContainer — Цвет содержимого, которое отображается поверх третичного контейнера.
 *
 * @ errorContainer — Предпочтительный тональный цвет контейнеров с ошибками.
 *
 * @ onErrorContainer — Цвет содержимого, которое отображается поверх контейнера с ошибкой.
 *
 * =================
 * || ПОВЕРХНОСТИ ||
 * =================
 *
 * @ surface — Цвет поверхностей компонентов (верхняя, нижняя и боковая панели,
 * а также карточки, листы и меню).
 *
 * @ onSurface — Цвет используемый для текста и значков, отображаемых поверх цвета поверхности
 * (заголовок верхней панели, подпись выделенного значка нижней панели, иконка кнопки Меню).
 *
 * @ surfaceVariant — Еще один вариант цвета с аналогичным использованием поверхности.
 *
 * @ onSurfaceVariant — Цвет используемый для текста и значков,
 * отображаемых поверх варианта цвета поверхности
 * (иконки кнопок верхней и нижней панели, пункты списка боковой панели).
 *
 * @ inverseSurface — Цвет, резко контрастирующий с основным цветом поверхностей.
 * Полезно для поверхностей, которые располагаются поверх других поверхностей
 * (цвет верхней системной панели с часами, индикатором зарядки и т.д.).
 *
 * @ inverseOnSurface — Цвет, который хорошо контрастирует с inverseSurface. Полезно для
 * содержимого, которое находится поверх контейнеров inverseSurface.
 *
 * @ surfaceTint — Этот цвет будет использоваться компонентами,
 * которые применяют повышение тона и наносятся поверх поверхности.
 * Чем выше высота, тем больше используется этот цвет
 * (нижняя панель навигации окрашивается с высокой прозрачностью выбранного цвета).
 */

/** Светлая тема **/
private val LightColorScheme = lightColorScheme(

    /* Главные цвета */
    primary = lPrimary, // Первичный цвет

    onPrimary = lOnPrimary, // На первичном цвете
    secondary = lSecondary, // Вторичный цвет
    onSecondary = lOnSecondary, // На вторичном цвете
    tertiary = lTertiary, // Третичный цвет
    onTertiary = lOnTertiary, // На третичном цвете
    inversePrimary = lInversePrimary, // Инвертированный первичный цвет

    /* Дополнительные цвета */
    background = lBackground, // Фоновый цвет
    onBackground = lOnBackground, // На фоновом цвете
    error = lError, // Цвет ошибки
    onError = lOnError, // На цвете ошибки
    outline = lOutline, // Контурный цвет
    outlineVariant = lOutlineVariant, // Вариант контурного цвета
    scrim = lScrim, // Цвет холста

    /* Контейнеры */
    primaryContainer = lPrimaryContainer, // Первичный контейнер
    onPrimaryContainer = lOnPrimaryContainer, // На первичном контейнере
    secondaryContainer = lSecondaryContainer, // Вторичный контейнер
    onSecondaryContainer = lOnSecondaryContainer, // На вторичном контейнере
    tertiaryContainer = lTertiaryContainer, // Третичный контейнер
    onTertiaryContainer = lOnTertiaryContainer, // На третичном контейнере
    errorContainer = lErrorContainer, // Контейнер ошибки
    onErrorContainer = lOnErrorContainer, // На контейнере ошибки

    /* Поверхности */
    surface = lSurface, // Поверхность
    onSurface = lOnSurface, // На поверхности
    surfaceVariant = lSurfaceVariant, // Вариант поверхности
    onSurfaceVariant = lOnSurfaceVariant, // На варианте поверхности
    inverseSurface = lInverseSurface, // Инвертированная поверхность
    inverseOnSurface = lInverseOnSurface, // На инвертированной поверхности
    surfaceTint = lSurfaceTint // Компоненты с тоном высоты (чем выше - тем ярче)
)

/** Тёмная тема **/
private val DarkColorScheme = darkColorScheme(

    /* Главные цвета */
    primary = dPrimary, // Первичный цвет
    onPrimary = dOnPrimary, // На первичном цвете
    secondary = dSecondary, // Вторичный цвет
    onSecondary = dOnSecondary, // На вторичном цвете
    tertiary = dTertiary, // Третичный цвет
    onTertiary = dOnTertiary, // На третичном цвете
    inversePrimary = dInversePrimary, // Инвертированный первичный цвет

    /* Дополнительные цвета */
    background = dBackground, // Фоновый цвет
    onBackground = dOnBackground, // На фоновом цвете
    error = dError, // Цвет ошибки
    onError = dOnError, // На цвете ошибки
    outline = dOutline, // Контурный цвет
    outlineVariant = dOutlineVariant, // Вариант контурного цвета
    scrim = dScrim, // Цвет холста

    /* Контейнеры */
    primaryContainer = dPrimaryContainer, // Первичный контейнер
    onPrimaryContainer = dOnPrimaryContainer, // На первичном контейнере
    secondaryContainer = dSecondaryContainer, // Вторичный контейнер
    onSecondaryContainer = dOnSecondaryContainer, // На вторичном контейнере
    tertiaryContainer = dTertiaryContainer, // Третичный контейнер
    onTertiaryContainer = dOnTertiaryContainer, // На третичном контейнере
    errorContainer = dErrorContainer, // Контейнер ошибки
    onErrorContainer = dOnErrorContainer, // На контейнере ошибки

    /* Поверхности */
    surface = dSurface, // Поверхность
    onSurface = dOnSurface, // На поверхности
    surfaceVariant = dSurfaceVariant, // Вариант поверхности
    onSurfaceVariant = dOnSurfaceVariant, // На варианте поверхности
    inverseSurface = dInverseSurface, // Инвертированная поверхность
    inverseOnSurface = dInverseOnSurface, // На инвертированной поверхности
    surfaceTint = dSurfaceTint // Компоненты с тоном высоты (чем выше - тем ярче)
)

@Composable
fun LessonjpcTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.inverseSurface.toArgb()
            WindowCompat.getInsetsController(
                window,
                view
            ).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}