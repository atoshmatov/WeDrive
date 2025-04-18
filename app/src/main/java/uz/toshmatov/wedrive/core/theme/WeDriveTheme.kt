package uz.toshmatov.wedrive.core.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import uz.toshmatov.wedrive.core.theme.color.LocalColors
import uz.toshmatov.wedrive.core.theme.color.darkColors
import uz.toshmatov.wedrive.core.theme.color.lightColors
import uz.toshmatov.wedrive.core.theme.deminsion.LocalCornerRadius
import uz.toshmatov.wedrive.core.theme.deminsion.LocalDimensions
import uz.toshmatov.wedrive.core.theme.deminsion.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.typography.LocalTypography
import uz.toshmatov.wedrive.core.theme.typography.WeDriveTypography
import uz.toshmatov.wedrive.core.utils.SetLightStatusBarAppearance

@Composable
fun WeDriveTheme(
    dimensions: WeDriveDimensions = AppTheme.dimensions,
    typography: WeDriveTypography = AppTheme.typography,
    corners: Shapes = AppTheme.cornerRadius,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    view.SetLightStatusBarAppearance(darkTheme)

    val rippleIndication = ripple()

    val currentColor = if (darkTheme) darkColors() else lightColors()

    val rememberedColors = remember {
        currentColor.copy()
    }.apply { updateColorsFrom(currentColor) }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalCornerRadius provides corners,
        LocalTypography provides typography,
        LocalIndication provides rippleIndication,
    ) {
        MaterialTheme(content = content)
    }
}