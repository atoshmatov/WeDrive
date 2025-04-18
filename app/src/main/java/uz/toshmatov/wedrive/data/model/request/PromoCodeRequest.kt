package uz.toshmatov.wedrive.data.model.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PromoCodeRequest(
	@SerialName("code")
	val code: String
)
