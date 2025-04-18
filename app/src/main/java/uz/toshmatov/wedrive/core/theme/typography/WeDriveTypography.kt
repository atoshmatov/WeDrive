package uz.toshmatov.wedrive.core.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import uz.toshmatov.wedrive.core.utils.weDriveFont

private val WeDriveFont = FontFamily(
    Font(weDriveFont.fig_tree_black, FontWeight.Black),
    Font(weDriveFont.fig_tree_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(weDriveFont.fig_tree_bold, FontWeight.Bold),
    Font(weDriveFont.fig_tree_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(weDriveFont.fig_tree_extra_bold, FontWeight.ExtraBold),
    Font(weDriveFont.fig_tree_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(weDriveFont.fig_tree_italic, FontWeight.Normal, FontStyle.Italic),
    Font(weDriveFont.fig_tree_light, FontWeight.Light),
    Font(weDriveFont.fig_tree_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(weDriveFont.fig_tree_medium, FontWeight.Medium),
    Font(weDriveFont.fig_tree_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(weDriveFont.fig_tree_regular, FontWeight.Normal),
    Font(weDriveFont.fig_tree_semi_bold, FontWeight.SemiBold),
    Font(weDriveFont.fig_tree_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
)

data class WeDriveTypography(
    // title
    val titleLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.titleLarge,
        lineHeight = TextSize.titleLargeLineHeight,
    ),
    val titleMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.titleMedium,
        lineHeight = TextSize.titleMediumLineHeight,
    ),
    val titleBold: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.titleBold,
        lineHeight = TextSize.titleBoldLineHeight,
    ),

    // button
    val buttonLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.buttonLarge,
        lineHeight = TextSize.buttonLargeLineHeight,
    ),
    val buttonMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.buttonMedium,
        lineHeight = TextSize.buttonMediumLineHeight,
    ),
    val buttonSmall: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.buttonSmall,
        lineHeight = TextSize.buttonSmallLineHeight,
    ),

    // label
    val labelLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.labelLarge,
        lineHeight = TextSize.labelLargeLineHeight,
    ),
    val labelMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.bodyMedium,
        lineHeight = TextSize.labelMediumLineHeight,
    ),

    // body text
    val bodyBold: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.bodyBold,
        lineHeight = TextSize.bodyBoldLineHeight,
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.bodyMedium,
        lineHeight = TextSize.bodyMediumLineHeight,
    ),

    // caption and small text
    val captionLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.captionLarge,
        lineHeight = TextSize.captionLargeLineHeight,
    ),
    val captionMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.captionMedium,
        lineHeight = TextSize.captionMediumLineHeight,
    ),
    val captionSmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = WeDriveFont,
        fontSize = TextSize.captionSmall,
        lineHeight = TextSize.captionSmallLineHeight,
    ),
    val captionBold: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = WeDriveFont,
        fontSize = TextSize.captionBold,
        lineHeight = TextSize.captionBoldLineHeight,
    ),
)


internal val LocalTypography = staticCompositionLocalOf { WeDriveTypography() }
