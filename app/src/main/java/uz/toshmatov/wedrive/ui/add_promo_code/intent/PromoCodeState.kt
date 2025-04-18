package uz.toshmatov.wedrive.ui.add_promo_code.intent

data class PromoCodeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
    val message: String = ""
)
