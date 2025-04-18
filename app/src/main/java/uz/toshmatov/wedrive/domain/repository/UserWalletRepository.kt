package uz.toshmatov.wedrive.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.toshmatov.wedrive.domain.model.UserWalletM

interface UserWalletRepository {
    suspend fun getUserWallet(): Flow<UserWalletM>
    suspend fun userPaymentMethod(
        activeMethod: String,
        activeCardId: Int,
    ): Flow<UserWalletM>
}