package uz.toshmatov.wedrive.core.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun String.formatToKoreanWon(): String {
    return try {
        val number = this.toDouble()
        val symbols = DecimalFormatSymbols(Locale.US).apply {
            groupingSeparator = ' ' // bo‘sh joy
            decimalSeparator = '.'
        }
        val formatter = DecimalFormat("#,##0.00", symbols)
        "${formatter.format(number)} ₩"
    } catch (e: NumberFormatException) {
        "Invalid input"
    }
}

fun String?.maskCardNumberSafe(): String {
    val last4 = this?.filter { it.isDigit() }?.takeLast(4) ?: "0000"
    return " **** $last4"
}

fun String.formatCardNumber(): String {
    return this.filter { it.isDigit() }
        .chunked(4)
        .joinToString(" ")
        .take(19)
}

fun String.formatExpiryDate(): String {
    val digits = this.filter { it.isDigit() }.take(4)
    return when {
        digits.length >= 3 -> digits.substring(0, 2) + "/" + digits.substring(2)
        digits.isNotEmpty() -> digits
        else -> ""
    }
}

fun String.formatPhoneNumberHidden(): String {
    return if (this.length == 13 && this.startsWith("+998")) {
        val code = this.substring(4, 6) // 93
        val last2 = this.takeLast(2)    // 20
        "+998 $code *** ** $last2"
    } else {
        this
    }
}