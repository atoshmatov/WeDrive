package uz.toshmatov.wedrive.data.apiservice

import kotlinx.coroutines.flow.Flow
import uz.toshmatov.wedrive.data.model.UserWalletDto

interface UserWalletApiService {
    suspend fun getUserWallet(): Flow<UserWalletDto>
    suspend fun userPaymentMethod(
        activeMethod: String,
        activeCardId: Int
    ): Flow<UserWalletDto>
}