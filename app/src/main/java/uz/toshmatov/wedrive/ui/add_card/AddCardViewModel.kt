package uz.toshmatov.wedrive.ui.add_card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.toshmatov.wedrive.domain.repository.UserCardRepository
import uz.toshmatov.wedrive.ui.add_card.intent.AddCardEvents
import uz.toshmatov.wedrive.ui.add_card.intent.AddCardState
import uz.toshmatov.wedrive.ui.wallet.intent.WalletState

class AddCardViewModel(
    private val userCardRepository: UserCardRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<AddCardState> = MutableStateFlow(AddCardState())
    val state: StateFlow<AddCardState> = _state.asStateFlow()

    fun reduce(event: AddCardEvents) {
        when (event) {
            is AddCardEvents.AddUserCard -> {
                addUserCard(
                    number = event.number,
                    expireDate = event.expireDate
                )
            }
        }
    }

    private fun addUserCard(
        number: String,
        expireDate: String
    ) {
        viewModelScope.launch {
            userCardRepository.addUserCard(
                number = number,
                expireDate = expireDate
            ).onStart {
                _state.update {
                    it.copy(
                        isLoading = true
                    )
                }
            }.onEach { cards ->
                _state.update {
                    it.copy(
                        isLoading = false,
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