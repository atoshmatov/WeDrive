package uz.toshmatov.wedrive.domain.model

import uz.toshmatov.wedrive.data.model.UserWalletDto

data class UserWalletM(
    val id: Int,
    val phone: String,
    val balance: Int,
    val activeMethod: String,
    val activeCardId: Int,
)

fun UserWalletDto.toWalletM() = UserWalletM(
    id = this.id,
    phone = this.phone,
    balance = this.balance,
    activeMethod = this.activeMethod,
    activeCardId = this.activeCardId,
)
