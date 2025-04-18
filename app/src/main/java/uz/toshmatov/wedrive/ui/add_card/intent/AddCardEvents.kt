package uz.toshmatov.wedrive.ui.add_card.intent

interface AddCardEvents {
    data class AddUserCard(
        val number: String,
        val expireDate: String
    ) : AddCardEvents
}