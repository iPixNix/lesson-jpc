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

/* public fun lightColorScheme(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    inversePrimary: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceTint: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    outline: Color,
    outlineVariant: Color,
    scrim: Color
): ColorScheme */

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