package uz.toshmatov.wedrive.core.theme.deminsion

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class WeDriveCornerRadius(
    val none: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
)

val WeDriveShapes = Shapes(
    extraSmall = Corners.extraSmall,
    small = Corners.small,
    medium = Corners.medium,
    large = Corners.large,
    extraLarge = Corners.extraLarge
)

object Corners {
    val extraSmall = RoundedCornerShape(2.dp)
    val small = RoundedCornerShape(4.dp)
    val medium = RoundedCornerShape(8.dp)
    val large = RoundedCornerShape(16.dp)
    val extraLarge = RoundedCornerShape(32.dp)
}

internal val LocalCornerRadius = staticCompositionLocalOf { WeDriveShapes }
