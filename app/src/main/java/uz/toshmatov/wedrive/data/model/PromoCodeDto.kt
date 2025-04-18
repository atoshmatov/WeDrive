package uz.toshmatov.wedrive.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PromoCodeDto(
	@SerialName("message")
	val message: String
)
