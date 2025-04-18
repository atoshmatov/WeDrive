package uz.toshmatov.wedrive.core.theme.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Common Colors
val WHITE = Color(0xFFFFFFFF)
val BLACK = Color(0xFF000000)
val DARK = Color(0xFF1A1A1A)
val Error = Color(0xFFCE2D2D)
val Success = Color(0xFF00FF9C)
val Orange = Color(0xFFE9A63F)
val Green = Color(0xFF009051)
val Blue = Color(0xFF0096FF)
val DarkBorder = Color(0xFF0C0C0C)
val Gray20 = Color(0xFFF7F8FC)
val Gray30 = Color(0xFFD9DBE2)
val Gray40 = Color(0xFFA1A5B7)
val Black20 = Color(0xFF1D1D1D)
val Black30 = Color(0xFF202125)

// gray
internal val GRAY = Color(0xFF727373)
internal val GRAY10 = Color(0xFFF4F4F4)


val LocalColors = staticCompositionLocalOf { lightColors() }