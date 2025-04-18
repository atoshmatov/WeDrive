package uz.toshmatov.wedrive.ui.wallet.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveCornerRadius
import uz.toshmatov.wedrive.core.theme.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.utils.formatPhoneNumberHidden
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveString

@Composable
fun WalletBalance(
    modifier: Modifier = Modifier,
    walletBalance: String = "00,000.00",
    walletPhoneNumber: String = ""
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(WeDriveCornerRadius.large)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF1B1B1B),
                        Color(0xFF3C3C3C)
                    )
                )
            )
            .padding(
                horizontal = WeDriveDimensions.medium,
                vertical = WeDriveDimensions.betweenItems
            ),
    ) {
        Text(
            text = weDriveString.home_balance.resource,
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            style = WeDriveTypography.bodyMedium,
            color = WeDriveColors.textPrimary,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = walletBalance,
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            style = WeDriveTypography.buttonLarge,
            color = WeDriveColors.textPrimary,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = walletPhoneNumber.formatPhoneNumberHidden(),
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            style = WeDriveTypography.bodyMedium,
            color = WeDriveColors.textPrimary,
        )
    }
}