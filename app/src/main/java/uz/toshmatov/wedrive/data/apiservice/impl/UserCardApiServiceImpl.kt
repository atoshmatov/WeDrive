package uz.toshmatov.wedrive.data.apiservice.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.toshmatov.wedrive.data.NetworkConstants.CARD_PATH
import uz.toshmatov.wedrive.data.apiservice.UserCardApiService
import uz.toshmatov.wedrive.data.model.UserCardsDto
import uz.toshmatov.wedrive.data.model.request.UserCardRequest

class UserCardApiServiceImpl(
    private val ktorClient: HttpClient,
) : UserCardApiService {
    override suspend fun getUserCards(): Flow<List<UserCardsDto>> = flow {
        val response = ktorClient.get {
            url {
                appendPathSegments(CARD_PATH)
                headers {
                    append(
                        "X-Account-Phone",
                        "+998932166120"
                    )
                }
            }
        }.body<List<UserCardsDto>>()
        emit(response)
    }

    override suspend fun addUserCard(
        number: String,
        expireDate: String
    ): Flow<Unit> = flow {
        val response = ktorClient.post {
            url {
                appendPathSegments(CARD_PATH)
                setBody(
                    UserCardRequest(
                        number = number,
                        expireDate = expireDate
                    )
                )
                headers {
                    append(
                        "X-Account-Phone",
                        "+998932166120"
                    )
                }
            }
        }.body<Unit>()
        emit(response)
    }
}