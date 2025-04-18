package uz.toshmatov.wedrive.domain.model

import uz.toshmatov.wedrive.data.model.PromoCodeDto

data class PromoCodeM(
    val message: String,
)


fun PromoCodeDto.toPromoCodeM(): PromoCodeM = PromoCodeM(
    message = this.message
)