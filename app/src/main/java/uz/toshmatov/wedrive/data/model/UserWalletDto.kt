package uz.toshmatov.wedrive.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserWalletDto(
    @SerialName("id")
    val id: Int,
    @SerialName("phone")
    val phone: String,
    @SerialName("balance")
    val balance: Int,
    @SerialName("active_method")
    val activeMethod: String,
    @SerialName("active_card_id")
    val activeCardId: Int,
)
