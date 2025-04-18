package uz.toshmatov.wedrive.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.toshmatov.wedrive.domain.model.PromoCodeM

interface PromoCodeRepository {
    suspend fun addPromoCode(code: String): Flow<PromoCodeM>
}