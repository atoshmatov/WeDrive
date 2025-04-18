package uz.toshmatov.wedrive.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import uz.toshmatov.wedrive.ui.add_card.AddCardViewModel
import uz.toshmatov.wedrive.ui.add_promo_code.PromoCodeViewModel
import uz.toshmatov.wedrive.ui.wallet.WalletViewModel

object VMModule {
    val viewModelModule = module {
        viewModel { WalletViewModel(get(), get()) }
        viewModel { AddCardViewModel(get()) }
        viewModel { PromoCodeViewModel(get()) }
    }
}