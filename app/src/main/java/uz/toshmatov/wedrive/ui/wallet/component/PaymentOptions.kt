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
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.ui.wallet.model.PaymentOptionsModel
import uz.toshmatov.wedrive.ui.wallet.model.PaymentOptionsType

@Composable
fun PaymentOptions(
    modifier: Modifier = Modifier,
    itemClick: (paymentOptionsType: PaymentOptionsType) -> Unit,
    inCashChecked: (Boolean) -> Unit,
    paymentOptionsModel: PaymentOptionsModel,
    cashChecked: Boolean = true,
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
            .clickable {
                itemClick(paymentOptionsModel.paymentOptionsType)
            }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeDriveIcon(image = paymentOptionsModel.icon)
        Spacer(Modifier.width(8.dp))
        Text(
            text = paymentOptionsModel.title.resource,
            style = WeDriveTypography.labelLarge,
            color = WeDriveColors.textSecondary,
        )
        Spacer(Modifier.weight(1f))
        if (paymentOptionsModel.isChecked) {
            CustomSwitch(
                checked = cashChecked,
                onCheckedChange = inCashChecked
            )
        } else {
            WeDriveIcon(
                image = weDriveDrawable.ic_right,
                onClick = {}
            )
        }
    }
}