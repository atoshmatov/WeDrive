package uz.toshmatov.wedrive.ui.wallet.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.uicomponent.WeDriveIcon
import uz.toshmatov.wedrive.core.utils.maskCardNumberSafe
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.core.utils.weDriveString
import uz.toshmatov.wedrive.domain.model.UserCardsM

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    itemClick: () -> Unit,
    userCardsM: UserCardsM
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(WeDriveColors.itemBackground)
            .clickable { itemClick() }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeDriveIcon(image = weDriveDrawable.ic_card)
        Spacer(Modifier.width(8.dp))
        Text(
            text = weDriveString.card.resource,
            style = WeDriveTypography.labelLarge,
            color = WeDriveColors.textSecondary,
        )
        Text(
            text = userCardsM.number.maskCardNumberSafe(),
            style = WeDriveTypography.labelLarge,
            color = WeDriveColors.textSecondary,
        )
        Spacer(Modifier.weight(1f))
        CustomSwitch(checked = true)
    }
}