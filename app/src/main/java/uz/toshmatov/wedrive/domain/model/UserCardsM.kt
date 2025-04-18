package uz.toshmatov.wedrive.domain.model

import uz.toshmatov.wedrive.data.model.UserCardsDto

data class UserCardsM(
    val id: Int,
    val number: String,
    val expireDate: String,
    val userId: Int,
)

fun UserCardsDto.toUModel() = UserCardsM(
    id = this.id,
    number = this.number,
    expireDate = this.expireDate,
    userId = this.userId
)
