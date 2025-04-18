package uz.toshmatov.wedrive.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.toshmatov.wedrive.domain.model.UserCardsM

interface UserCardRepository {
    suspend fun getUserCards(): Flow<List<UserCardsM>>
    suspend fun addUserCard(
        number: String,
        expireDate: String
    ): Flow<Unit>
}