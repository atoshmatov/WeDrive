package uz.toshmatov.wedrive.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import uz.toshmatov.wedrive.data.apiservice.UserWalletApiService
import uz.toshmatov.wedrive.domain.model.UserWalletM
import uz.toshmatov.wedrive.domain.model.toWalletM
import uz.toshmatov.wedrive.domain.repository.UserWalletRepository

class UserWalletRepositoryImpl(
    private val userWalletApiService: UserWalletApiService
) : UserWalletRepository {
    override suspend fun getUserWallet(): Flow<UserWalletM> {
        return userWalletApiService.getUserWallet()
            .map { userWallet ->
                userWallet.toWalletM()
            }.flowOn(Dispatchers.IO)
    }

    override suspend fun userPaymentMethod(
        activeMethod: String,
        activeCardId: Int
    ): Flow<UserWalletM> {
        return userWalletApiService.userPaymentMethod(
            activeMethod = activeMethod,
            activeCardId = activeCardId
        ).map { userWalletDto ->
            userWalletDto.toWalletM()
        }.flowOn(Dispatchers.IO)
    }
}