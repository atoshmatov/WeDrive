package uz.toshmatov.wedrive.core.theme

import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import uz.toshmatov.wedrive.core.theme.color.LocalColors
import uz.toshmatov.wedrive.core.theme.color.WeDriveColors
import uz.toshmatov.wedrive.core.theme.deminsion.LocalCornerRadius
import uz.toshmatov.wedrive.core.theme.deminsion.LocalDimensions
import uz.toshmatov.wedrive.core.theme.deminsion.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.typography.LocalTypography
import uz.toshmatov.wedrive.core.theme.typography.WeDriveTypography

val WeDriveColors
    @Composable
    get() = AppTheme.colors

val WeDriveDimensions
    @Composable
    get() = AppTheme.dimensions

val WeDriveCornerRadius
    @Composable
    get() = AppTheme.cornerRadius

val WeDriveTypography
    @Composable
    get() = AppTheme.typography

internal object AppTheme {
    val colors: WeDriveColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val dimensions: WeDriveDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val cornerRadius: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalCornerRadius.current

    val typography: WeDriveTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
