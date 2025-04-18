package uz.toshmatov.wedrive.core.uicomponent

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.WeDriveTypography

@Composable
fun CompletedButton(
    modifier: Modifier = Modifier,
    onCompleted: () -> Unit,
    textContent: String,
    enabled: Boolean = true,
    containerColor: Color = WeDriveColors.button,
    contentColor: Color = WeDriveColors.textPrimary,
    disabledContainerColor: Color = WeDriveColors.buttonEnable,
    disabledContentColor: Color = WeDriveColors.buttonContent,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(bottom = WeDriveDimensions.screenPadding),
        onClick = onCompleted,
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContentColor = disabledContentColor,
            disabledContainerColor = disabledContainerColor,
        ),
        shape = RoundedCornerShape(WeDriveDimensions.small),
        enabled = enabled
    ) {
        Text(
            textContent,
            style = WeDriveTypography.buttonSmall,
        )
    }
}

@Composable
fun WeDriveTextButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = Color.Unspecified,
    containerColor: Color = Color.Unspecified,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = color,
            containerColor = containerColor
        ),
        content = content,
        shape = RoundedCornerShape(4.dp),
    )
}