package uz.toshmatov.wedrive.ui.wallet.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PaymentOptionsModel(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val paymentOptionsType: PaymentOptionsType,
    val isChecked: Boolean = false,
)
