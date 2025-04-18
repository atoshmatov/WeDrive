package uz.toshmatov.wedrive.di

import org.koin.dsl.module
import uz.toshmatov.wedrive.data.repository.PromoCodeRepositoryImpl
import uz.toshmatov.wedrive.data.repository.UserCardRepositoryImpl
import uz.toshmatov.wedrive.data.repository.UserWalletRepositoryImpl
import uz.toshmatov.wedrive.domain.repository.PromoCodeRepository
import uz.toshmatov.wedrive.domain.repository.UserCardRepository
import uz.toshmatov.wedrive.domain.repository.UserWalletRepository

object RPModule {
    val repositoryModule = module {
        factory<UserCardRepository> { UserCardRepositoryImpl(get()) }
        factory<UserWalletRepository> { UserWalletRepositoryImpl(get()) }
        factory<PromoCodeRepository> { PromoCodeRepositoryImpl(get()) }
    }
}