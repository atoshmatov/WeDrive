package uz.toshmatov.wedrive.data.apiservice.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.toshmatov.wedrive.data.NetworkConstants.WALLET_PATH
import uz.toshmatov.wedrive.data.NetworkConstants.WALLET_PATH_METHOD
import uz.toshmatov.wedrive.data.apiservice.UserWalletApiService
import uz.toshmatov.wedrive.data.model.UserWalletDto
import uz.toshmatov.wedrive.data.model.request.UserWalletRequest

class UserWalletApiServiceImpl(private val ktorClient: HttpClient) : UserWalletApiService {
    override suspend fun getUserWallet(): Flow<UserWalletDto> = flow {
        val response = ktorClient.get {
            url {
                appendPathSegments(WALLET_PATH)
                headers {
                    append(
                        "X-Account-Phone",
                        "+998932166120"
                    )
                }
            }
        }.body<UserWalletDto>()
        emit(response)
    }

    override suspend fun userPaymentMethod(
        activeMethod: String,
        activeCardId: Int
    ): Flow<UserWalletDto> =
        flow {
            val response = ktorClient.put {
                url {
                    appendPathSegments(WALLET_PATH_METHOD)
                    setBody(
                        UserWalletRequest(
                            activeMethod = activeMethod,
                            activeCardId = activeCardId
                        )
                    )
                    headers {
                        append(
                            "X-Account-Phone",
                            "+998932166120"
                        )
                    }
                }
            }.body<UserWalletDto>()
            emit(response)
        }
}