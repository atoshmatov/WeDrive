package uz.toshmatov.wedrive.ui.add_card.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveCornerRadius
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.utils.CreditCardVisualTransformation
import uz.toshmatov.wedrive.core.utils.ExpiryDateVisualTransformation

@SuppressLint("InvalidColorHexValue")
@Composable
fun AddCardItem(
    modifier: Modifier = Modifier,
    onCardNumberChange: (String) -> Unit = {},
    onCardNumberDateChange: (String) -> Unit = {},
) {
    var cardNumber by remember { mutableStateOf("") }
    var cardNumberDate by remember { mutableStateOf("") }
    val dateFocusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        dateFocusRequester.freeFocus()
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = WeDriveCornerRadius.large
            )
            .border(
                width = 2.dp,
                color = WeDriveColors.textPrimary,
                shape = WeDriveCornerRadius.large
            )
            .background(
                color = WeDriveColors.itemBackground,
                shape = WeDriveCornerRadius.large
            )
            .padding(16.dp),
    ) {
        OutlinedTextField(
            value = cardNumber,
            onValueChange = {
                val digits = it.filter { c -> c.isDigit() }.take(16)
                cardNumber = digits
                onCardNumberChange(cardNumber)

                if (digits.length == 16) {
                    dateFocusRequester.requestFocus()
                }
            },
            visualTransformation = CreditCardVisualTransformation(),
            placeholder = {
                Text(
                    text = "0000 0000 0000 0000",
                    style = WeDriveTypography.labelLarge,
                    color = WeDriveColors.bottomBarIconUnSelected
                )
            },
            textStyle = WeDriveTypography.labelLarge,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = WeDriveColors.background,
                unfocusedContainerColor = WeDriveColors.background,
                focusedBorderColor = Color(0x4d8e8e8e),
                unfocusedBorderColor = Color(0x4d8e8e8e),
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = cardNumberDate,
            onValueChange = {
                cardNumberDate = it.filter { c -> c.isDigit() }.take(4)
                onCardNumberDateChange(cardNumberDate)
            },
            visualTransformation = ExpiryDateVisualTransformation(),
            placeholder = {
                Text(
                    text = "00/00",
                    style = WeDriveTypography.labelLarge,
                    color = WeDriveColors.bottomBarIconUnSelected
                )
            },
            textStyle = WeDriveTypography.labelLarge,
            singleLine = true,
            modifier = Modifier
                .width(120.dp)
                .focusRequester(dateFocusRequester),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = WeDriveColors.background,
                unfocusedContainerColor = WeDriveColors.background,
                focusedBorderColor = Color(0x4d8e8e8e),
                unfocusedBorderColor = Color(0x4d8e8e8e),
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        )
    }
}


