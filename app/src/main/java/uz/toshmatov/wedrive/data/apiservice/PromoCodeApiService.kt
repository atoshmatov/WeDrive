package uz.toshmatov.wedrive.data.apiservice

import kotlinx.coroutines.flow.Flow
import uz.toshmatov.wedrive.data.model.PromoCodeDto

interface PromoCodeApiService {
    suspend fun addPromoCode(code: String): Flow<PromoCodeDto>
}