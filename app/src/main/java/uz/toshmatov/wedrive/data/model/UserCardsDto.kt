package uz.toshmatov.wedrive.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserCardsDto(
    @SerialName("id")
    val id: Int,
    @SerialName("number")
    val number: String,
    @SerialName("expire_date")
    val expireDate: String,
    @SerialName("user_id")
    val userId: Int,
)
