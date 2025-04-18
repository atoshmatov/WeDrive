package uz.toshmatov.wedrive.core.uicomponent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun WeDriveIcon(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    padding: Dp = 4.dp,
    color: Color = Color.Unspecified,
    onClick: (() -> Unit)? = null,
    contentDescription: String = "default",
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
            .then(
                if (onClick != null) {
                    modifier.clickable { onClick() }
                } else {
                    modifier
                },
            )
            .padding(padding),
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size(size),
        )
    }
}
