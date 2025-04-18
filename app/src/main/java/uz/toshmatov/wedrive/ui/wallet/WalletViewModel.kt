package uz.toshmatov.wedrive.ui.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.toshmatov.wedrive.core.logger.logInfo
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.core.utils.weDriveString
import uz.toshmatov.wedrive.domain.repository.UserCardRepository
import uz.toshmatov.wedrive.domain.repository.UserWalletRepository
import uz.toshmatov.wedrive.ui.wallet.intent.WallerEvents
import uz.toshmatov.wedrive.ui.wallet.intent.WalletState
import uz.toshmatov.wedrive.ui.wallet.model.PaymentOptionsModel
import uz.toshmatov.wedrive.ui.wallet.model.PaymentOptionsType

class WalletViewModel(
    private val userCardRepository: UserCardRepository,
    private val userWalletRepository: UserWalletRepository
) : ViewModel() {
    private val _state: MutableStateFlow<WalletState> = MutableStateFlow(WalletState())
    val state: StateFlow<WalletState> = _state.asStateFlow()

    private val paymentOptions = listOf(
        PaymentOptionsModel(
            title = weDriveString.promo_code,
            icon = weDriveDrawable.ic_promokod,
            paymentOptionsType = PaymentOptionsType.PromoCode
        ),
        PaymentOptionsModel(
            title = weDriveString.cash,
            icon = weDriveDrawable.ic_cash,
            paymentOptionsType = PaymentOptionsType.PromoCode,
            isChecked = true
        ),
    )

    init {
        getUserCards()
        getUserWallet()
        _state.update {
            it.copy(
                paymentOptionModels = paymentOptions.toPersistentList()
            )
        }
    }

    fun reduce(event: WallerEvents) {
        when (event) {
            is WallerEvents.UserWalletPaymentMethod -> {
                userWalletPaymentMethod(
                    activeMethod = event.activeMethod,
                    activeCardId = event.activeCardId
                )
            }
        }
    }

    fun getUserCards() {
        viewModelScope.launch {
            userCardRepository.getUserCards()
                .onStart {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }.onEach { cards ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            userCards = cards.distinctBy { card -> card.number }
                                .toPersistentList()
                        )
                    }
                }.catch { e ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = e.message
                        )
                    }
                }.launchIn(viewModelScope)
        }
    }

    fun getUserWallet() {
        viewModelScope.launch {
            userWalletRepository.getUserWallet()
                .onStart {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }.onEach { wallet ->
                    logInfo { "wallet --> $wallet" }

                    _state.update {
                        it.copy(
                            isLoading = false,
                            userWalletPhone = wallet.phone,
                            userWalletBalance = wallet.balance.toString(),
                            userWalletActiveMethod = wallet.activeMethod
                        )
                    }
                }.catch { e ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = e.message
                        )
                    }
                }.launchIn(viewModelScope)
        }
    }

    fun userWalletPaymentMethod(
        activeMethod: String,
        activeCardId: Int
    ) {
        viewModelScope.launch {
            userWalletRepository.userPaymentMethod(
                activeMethod = activeMethod,
                activeCardId = activeCardId
            ).onStart {
                _state.update {
                    it.copy(
                        isLoading = true
                    )
                }
            }.onEach { wallet ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        userWalletPhone = wallet.phone,
                        userWalletBalance = wallet.balance.toString(),
                        userWalletActiveMethod = wallet.activeMethod
                    )
                }
            }.catch { e ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }.launchIn(viewModelScope)
        }
    }
}