package uz.toshmatov.wedrive.data.model.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserWalletRequest(
    @SerialName("active_card_id")
    val activeCardId: Int,
    @SerialName("active_method")
    val activeMethod: String,
)
