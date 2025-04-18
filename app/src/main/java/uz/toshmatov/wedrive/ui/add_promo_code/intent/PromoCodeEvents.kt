package uz.toshmatov.wedrive.ui.add_promo_code.intent

interface PromoCodeEvents {
    data class AddPromoCode(val code: String) : PromoCodeEvents
}