package uz.toshmatov.wedrive.ui.wallet.intent

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import uz.toshmatov.wedrive.domain.model.UserCardsM
import uz.toshmatov.wedrive.ui.wallet.model.PaymentOptionsModel

data class WalletState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val userWalletBalance: String = "",
    val userWalletPhone: String = "",
    val userWalletActiveMethod: String = "",
    val paymentOptionModels: ImmutableList<PaymentOptionsModel> = persistentListOf(),
    val userCards: ImmutableList<UserCardsM> = persistentListOf(),
)
