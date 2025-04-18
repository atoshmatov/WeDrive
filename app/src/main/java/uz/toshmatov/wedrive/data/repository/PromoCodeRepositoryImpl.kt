package uz.toshmatov.wedrive.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import uz.toshmatov.wedrive.core.logger.logInfo
import uz.toshmatov.wedrive.data.apiservice.PromoCodeApiService
import uz.toshmatov.wedrive.domain.model.PromoCodeM
import uz.toshmatov.wedrive.domain.model.toPromoCodeM
import uz.toshmatov.wedrive.domain.repository.PromoCodeRepository

class PromoCodeRepositoryImpl(
    private val promoCodeApi: PromoCodeApiService
) : PromoCodeRepository {
    override suspend fun addPromoCode(code: String): Flow<PromoCodeM> {
        logInfo { "promo --> $code" }
        return promoCodeApi.addPromoCode(code)
            .map { promoCodeDto ->
                logInfo { "promo --> ${promoCodeDto.message}" }
                promoCodeDto.toPromoCodeM()
            }.flowOn(Dispatchers.IO)
    }
}