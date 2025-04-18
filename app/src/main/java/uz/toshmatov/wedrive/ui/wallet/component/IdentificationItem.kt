package uz.toshmatov.wedrive.ui.wallet.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.uicomponent.WeDriveIcon
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.core.utils.weDriveString

@Composable
fun IdentificationItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = WeDriveColors.divider,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeDriveIcon(image = weDriveDrawable.ic_info_circle)
        Spacer(Modifier.width(8.dp))
        Text(
            text = weDriveString.identification_required.resource,
            style = WeDriveTypography.labelLarge,
            color = WeDriveColors.textSecondary,
        )
        Spacer(Modifier.weight(1f))
        WeDriveIcon(
            image = weDriveDrawable.ic_arrow_up_right,
            onClick = {}
        )
    }
}