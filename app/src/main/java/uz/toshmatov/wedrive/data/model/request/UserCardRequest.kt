package uz.toshmatov.wedrive.data.model.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserCardRequest(
	@SerialName("number")
	val number: String,
	@SerialName("expire_date")
	val expireDate: String
)
