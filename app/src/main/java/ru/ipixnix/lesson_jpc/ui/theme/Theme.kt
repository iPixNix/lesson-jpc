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
 * @ secondaryContainer — Цвет вторичных контейнеров.
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
 * @ surface — Цвет поверхностей компонентов, таких как карточки, листы и меню.
 *
 * @ onSurface — Цвет используемый для текста и значков, отображаемых поверх цвета поверхности.
 *
 * @ surfaceVariant — Еще один вариант цвета с аналогичным использованием поверхности.
 *
 * @ onSurfaceVariant — Цвет используемый для текста и значков, отображаемых поверх варианта цвета
 * поверхности.
 *
 * @ inverseSurface — Цвет, резко контрастирующий с основным цветом поверхностей. Полезно для
 * поверхностей, которые располагаются поверх других поверхностей.
 *
 * @ inverseOnSurface — Цвет, который хорошо контрастирует с inverseSurface. Полезно для
 * содержимого, которое находится поверх контейнеров inverseSurface.
 *
 * @ surfaceTint — Этот цвет будет использоваться компонентами, которые применяют повышение тона
 * и наносятся поверх поверхности. Чем выше высота, тем больше используется этот цвет.
 *
 */

/** Тёмная тема **/
private val DarkColorScheme = darkColorScheme(

    /* Главные цвета */
    primary = clrDPrimary, // Первичный цвет
    onPrimary = clrDOnPrimary, // На первичном цвете
    secondary = clrDSecondary, // Вторичный цвет
    onSecondary = clrDOnSecondary, // На вторичном цвете
    tertiary = clrDTertiary, // Третичный цвет
    onTertiary = clrDOnTertiary, // На третичном цвете
    inversePrimary = clrDInversePrimary, // Инвертированный первичный цвет

    /* Дополнительные цвета */
    background = clrDBackground, // Фоновый цвет
    onBackground = clrDOnBackground, // На фоновом цвете
    error = clrDError, // Цвет ошибки
    onError = clrDOnError, // На цвете ошибки
    outline = clrDOutline, // Контурный цвет
    outlineVariant = clrDOutlineVariant, // Вариант контурного цвета
    scrim = clrDScrim, // Цвет холста

    /* Контейнеры */
    primaryContainer = clrDPrimaryContainer, // Первичный контейнер
    onPrimaryContainer = clrDOnPrimaryContainer, // На первичном контейнере
    secondaryContainer = clrDSecondaryContainer, // Вторичный контейнер
    onSecondaryContainer = clrDOnSecondaryContainer, // На вторичном контейнере
    tertiaryContainer = clrDTertiaryContainer, // Третичный контейнер
    onTertiaryContainer = clrDOnTertiaryContainer, // На третичном контейнере
    errorContainer = clrDErrorContainer, // Контейнер ошибки
    onErrorContainer = clrDOnErrorContainer, // На контейнере ошибки

    /* Поверхности */
    surface = clrDSurface, // Поверхность
    onSurface = clrDOnSurface, // На поверхности
    surfaceVariant = clrDSurfaceVariant, // Вариант поверхности
    onSurfaceVariant = clrDOnSurfaceVariant, // На варианте поверхности
    inverseSurface = clrDInverseSurface, // Инвертированная поверхность
    inverseOnSurface = clrDInverseOnSurface, // На инвертированной поверхности
    surfaceTint = clrDSurfaceTint // Компоненты с тоном высоты (чем выше - тем ярче)
)

/** Светлая тема **/
private val LightColorScheme = lightColorScheme(

    /* Главные цвета */
    primary = clrLPrimary, // Первичный цвет
    onPrimary = clrLOnPrimary, // На первичном цвете
    secondary = clrLSecondary, // Вторичный цвет
    onSecondary = clrLOnSecondary, // На вторичном цвете
    tertiary = clrLTertiary, // Третичный цвет
    onTertiary = clrLOnTertiary, // На третичном цвете
    inversePrimary = clrLInversePrimary, // Инвертированный первичный цвет

    /* Дополнительные цвета */
    background = clrLBackground, // Фоновый цвет
    onBackground = clrLOnBackground, // На фоновом цвете
    error = clrLError, // Цвет ошибки
    onError = clrLOnError, // На цвете ошибки
    outline = clrLOutline, // Контурный цвет
    outlineVariant = clrLOutlineVariant, // Вариант контурного цвета
    scrim = clrLScrim, // Цвет холста

    /* Контейнеры */
    primaryContainer = clrLPrimaryContainer, // Первичный контейнер
    onPrimaryContainer = clrLOnPrimaryContainer, // На первичном контейнере
    secondaryContainer = clrLSecondaryContainer, // Вторичный контейнер
    onSecondaryContainer = clrLOnSecondaryContainer, // На вторичном контейнере
    tertiaryContainer = clrLTertiaryContainer, // Третичный контейнер
    onTertiaryContainer = clrLOnTertiaryContainer, // На третичном контейнере
    errorContainer = clrLErrorContainer, // Контейнер ошибки
    onErrorContainer = clrLOnErrorContainer, // На контейнере ошибки

    /* Поверхности */
    surface = clrLSurface, // Поверхность
    onSurface = clrLOnSurface, // На поверхности
    surfaceVariant = clrLSurfaceVariant, // Вариант поверхности
    onSurfaceVariant = clrLOnSurfaceVariant, // На варианте поверхности
    inverseSurface = clrLInverseSurface, // Инвертированная поверхность
    inverseOnSurface = clrLInverseOnSurface, // На инвертированной поверхности
    surfaceTint = clrLSurfaceTint // Компоненты с тоном высоты (чем выше - тем ярче)
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
            window.statusBarColor = colorScheme.surface.toArgb()
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