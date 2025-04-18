package uz.toshmatov.wedrive.core.theme.deminsion

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class WeDriveDimensions(
    val none: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
    val betweenItems: Dp = 12.dp,  // Elementlar orasidagi masofa
    val screenPadding: Dp = 20.dp, // Ekran chetlaridagi padding
    val defaultRadius: Dp = 20.dp  // Default radius
)

internal val LocalDimensions = staticCompositionLocalOf { WeDriveDimensions() }