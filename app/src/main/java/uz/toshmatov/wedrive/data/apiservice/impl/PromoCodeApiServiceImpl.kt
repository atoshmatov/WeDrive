package uz.toshmatov.wedrive.data.apiservice.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.toshmatov.wedrive.data.NetworkConstants.PROMO_CODE
import uz.toshmatov.wedrive.data.apiservice.PromoCodeApiService
import uz.toshmatov.wedrive.data.model.PromoCodeDto
import uz.toshmatov.wedrive.data.model.request.PromoCodeRequest

class PromoCodeApiServiceImpl(
    private val ktorClient: HttpClient
) : PromoCodeApiService {
    override suspend fun addPromoCode(code: String): Flow<PromoCodeDto> = flow {
        val response = ktorClient.post {
            url {
                appendPathSegments(PROMO_CODE)
                setBody(
                    PromoCodeRequest(
                        code = code
                    )
                )
                headers {
                    append(
                        "X-Account-Phone",
                        "+998932166120"
                    )
                }
            }
        }.body<PromoCodeDto>()
        emit(response)
    }
}