package uz.toshmatov.wedrive.core.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.take(16).filter { it.isDigit() }
        val out = StringBuilder()
        for (i in trimmed.indices) {
            out.append(trimmed[i])
            if ((i + 1) % 4 == 0 && i != trimmed.lastIndex) out.append(" ")
        }

        val offsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                var spaces = 0
                for (i in 0 until offset.coerceAtMost(trimmed.length)) {
                    if (i > 0 && i % 4 == 0) spaces++
                }
                return offset + spaces
            }

            override fun transformedToOriginal(offset: Int): Int {
                return offset - (offset / 5)
            }
        }

        return TransformedText(AnnotatedString(out.toString()), offsetTranslator)
    }
}
