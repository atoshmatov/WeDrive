package uz.toshmatov.wedrive.ui.add_promo_code

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.toshmatov.wedrive.domain.repository.PromoCodeRepository
import uz.toshmatov.wedrive.ui.add_promo_code.intent.PromoCodeEvents
import uz.toshmatov.wedrive.ui.add_promo_code.intent.PromoCodeState

class PromoCodeViewModel(
    private val promoCodeRepository: PromoCodeRepository
) : ViewModel() {

    private val _state: MutableStateFlow<PromoCodeState> = MutableStateFlow(PromoCodeState())
    val state: StateFlow<PromoCodeState> = _state.asStateFlow()

    fun reduce(event: PromoCodeEvents) {
        when (event) {
            is PromoCodeEvents.AddPromoCode -> addPromoCode(event.code)
        }
    }

    private fun addPromoCode(code: String) {
        viewModelScope.launch {
            promoCodeRepository.addPromoCode(code)
                .onStart {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }.onEach { promo ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            message = promo.message,
                            success = true
                        )
                    }
                }.catch { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
                }.launchIn(viewModelScope)
        }
    }
}