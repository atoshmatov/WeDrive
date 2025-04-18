package uz.toshmatov.wedrive.ui.add_card.intent

data class AddCardState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)
