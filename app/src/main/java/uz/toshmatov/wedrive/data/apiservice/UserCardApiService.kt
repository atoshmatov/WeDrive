package uz.toshmatov.wedrive.data.apiservice

import kotlinx.coroutines.flow.Flow
import uz.toshmatov.wedrive.data.model.UserCardsDto

interface UserCardApiService {
    suspend fun getUserCards(): Flow<List<UserCardsDto>>
    suspend fun addUserCard(
        number: String,
        expireDate: String
    ): Flow<Unit>
}