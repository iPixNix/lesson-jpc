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
 * @ primary — Первичный цвет. Это цвет, который чаще всего отображается на экранах и в
 * компонентах вашего приложения.
 *
 * @ onPrimary — Цвет используемый для текста и значков, отображаемых поверх первичного цвета.
 *
 * @ primaryContainer — Цвет первичных контейнеров.
 *
 * @ onPrimaryContainer — Цвет содержимого, которое отображается поверх первичного контейнера.
 *
 * @ inversePrimary — Цвет, который будет использоваться в качестве первичного цвета в местах,
 * где необходима инверсная цветовая схема, например, кнопка на SnackBar.
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
 * @ secondaryContainer — Цвет вторичных контейнеров.
 *
 * @ onSecondaryContainer — Цвет содержимого, которое отображается поверх вторичного контейнера.
 *
 * @ tertiary — Третичный цвет можно использовать для баланса основных и вторичных цветов
 * или для привлечения повышенного внимания к такому элементу, как поле ввода.
 *
 * @ onTertiary — Цвет используемый для текста и значков, отображаемых поверх третичного цвета.
 *
 * @ tertiaryContainer — Цвет третичных контейнеров.
 *
 * @ onTertiaryContainer — Цвет содержимого, которое отображается поверх третичного контейнера.
 *
 * @ background — Цвет фона, который появляется за прокручиваемым содержимым.
 *
 * @ onBackground — Цвет используемый для текста и значков, отображаемых поверх цвета фона.
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
 * @ surfaceTint — Этот цвет будет использоваться компонентами, которые применяют повышение тона
 * и наносятся поверх поверхности. Чем выше высота, тем больше используется этот цвет.
 *
 * @ inverseSurface — Цвет, резко контрастирующий с основным цветом поверхностей. Полезно для
 * поверхностей, которые располагаются поверх других поверхностей.
 *
 * @ inverseOnSurface — Цвет, который хорошо контрастирует с inverseSurface. Полезно для
 * содержимого, которое находится поверх контейнеров inverseSurface.
 *
 * @ error — Цвет ошибки используется для обозначения ошибок в компонентах, например
 * недопустимого текста в текстовом поле.
 *
 * @ onError — Цвет используемый для текста и значков, отображаемых поверх цвета ошибки.
 *
 * @ errorContainer — Предпочтительный тональный цвет контейнеров с ошибками.
 *
 * @ onErrorContainer — Цвет содержимого, которое отображается поверх контейнера с ошибкой.
 *
 * @ outline — Цвет, используемый для границ декоративных элементов.
 *
 * @ outlineVariant — Вариант цвета границ элементов, когда не требуется сильный контраст.
 *
 * @ scrim — Цвет холста, скрывающего содержимое.
 *
 */

/** Тёмная тема */
private val DarkColorScheme = darkColorScheme(
    /* Главные цвета */
    primary = clrDPrimary,
    onPrimary = clrDOnPrimary,
    inversePrimary = clrDInversePrimary,
    secondary = clrDSecondary,
    onSecondary = clrDOnSecondary,
    tertiary = clrDTertiary,
    onTertiary = clrDOnTertiary,
    /* Дополнительные цвета */
    background = clrDBackground,
    onBackground = clrDOnBackground,
    error = clrDError,
    onError = clrDOnError,
    outline = clrDOutline,
    outlineVariant = clrDOutlineVariant,
    scrim = clrDScrim,
    /* Поверхности */
    surface = clrDSurface,
    onSurface = clrDOnSurface,
    inverseSurface = clrDInverseSurface,
    inverseOnSurface = clrDInverseOnSurface,
    surfaceVariant = clrDSurfaceVariant,
    onSurfaceVariant = clrDOnSurfaceVariant,
    surfaceTint = clrDSurfaceTint,
    /* Контейнеры */
    primaryContainer = clrDPrimaryContainer,
    onPrimaryContainer = clrDOnPrimaryContainer,
    secondaryContainer = clrDSecondaryContainer,
    onSecondaryContainer = clrDOnSecondaryContainer,
    tertiaryContainer = clrDTertiaryContainer,
    onTertiaryContainer = clrDOnTertiaryContainer,
    errorContainer = clrDErrorContainer,
    onErrorContainer = clrDOnErrorContainer
)

/** Светлая тема */
private val LightColorScheme = lightColorScheme(
    /* Главные цвета */
    primary = clrLPrimary,
    onPrimary = clrLOnPrimary,
    inversePrimary = clrLInversePrimary,
    secondary = clrLSecondary,
    onSecondary = clrLOnSecondary,
    tertiary = clrLTertiary,
    onTertiary = clrLOnTertiary,
    /* Дополнительные цвета */
    background = clrLBackground,
    onBackground = clrLOnBackground,
    error = clrLError,
    onError = clrLOnError,
    outline = clrLOutline,
    outlineVariant = clrLOutlineVariant,
    scrim = clrLScrim,
    /* Поверхности */
    surface = clrLSurface,
    onSurface = clrLOnSurface,
    inverseSurface = clrLInverseSurface,
    inverseOnSurface = clrLInverseOnSurface,
    surfaceVariant = clrLSurfaceVariant,
    onSurfaceVariant = clrLOnSurfaceVariant,
    surfaceTint = clrLSurfaceTint,
    /* Контейнеры */
    primaryContainer = clrLPrimaryContainer,
    onPrimaryContainer = clrLOnPrimaryContainer,
    secondaryContainer = clrLSecondaryContainer,
    onSecondaryContainer = clrLOnSecondaryContainer,
    tertiaryContainer = clrLTertiaryContainer,
    onTertiaryContainer = clrLOnTertiaryContainer,
    errorContainer = clrLErrorContainer,
    onErrorContainer = clrLOnErrorContainer
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
            window.statusBarColor = colorScheme.secondary.toArgb()
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