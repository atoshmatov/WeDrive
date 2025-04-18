package uz.toshmatov.wedrive.ui.wallet.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.toshmatov.wedrive.core.theme.WeDriveColors

@Composable
fun CustomSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var checkedCash by remember { mutableStateOf(checked) }

    Box(
        modifier = modifier
            .size(36.dp)
    ) {
        Switch(
            checked = checkedCash,
            onCheckedChange = {
                checkedCash = it
                onCheckedChange(it)
            },
            modifier = Modifier
                .align(Alignment.Center)
                .scale(0.75f), // bu yerda switch ni kichiklashtirdik
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = WeDriveColors.switch,
                uncheckedThumbColor = WeDriveColors.switch,
                uncheckedTrackColor = WeDriveColors.icon,
                uncheckedBorderColor = WeDriveColors.switch,
            )
        )
    }
}