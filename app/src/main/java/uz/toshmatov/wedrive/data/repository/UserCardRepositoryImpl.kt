package uz.toshmatov.wedrive.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import uz.toshmatov.wedrive.data.apiservice.UserCardApiService
import uz.toshmatov.wedrive.domain.model.UserCardsM
import uz.toshmatov.wedrive.domain.model.toUModel
import uz.toshmatov.wedrive.domain.repository.UserCardRepository

class UserCardRepositoryImpl(
    private val userCardApiService: UserCardApiService
) : UserCardRepository {
    override suspend fun getUserCards(): Flow<List<UserCardsM>> {
        return userCardApiService.getUserCards()
            .map { userCards ->
                userCards.map { userCard ->
                    userCard.toUModel()
                }
            }.flowOn(Dispatchers.IO)
    }

    override suspend fun addUserCard(
        number: String,
        expireDate: String
    ): Flow<Unit> {
        return userCardApiService.addUserCard(
            number = number,
            expireDate = expireDate
        ).flowOn(Dispatchers.IO)
    }
}