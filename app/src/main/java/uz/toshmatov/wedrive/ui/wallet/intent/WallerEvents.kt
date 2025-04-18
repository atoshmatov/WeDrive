package uz.toshmatov.wedrive.ui.wallet.intent

interface WallerEvents {
    data class UserWalletPaymentMethod(
        val activeMethod: String,
        val activeCardId: Int
    ) : WallerEvents
}