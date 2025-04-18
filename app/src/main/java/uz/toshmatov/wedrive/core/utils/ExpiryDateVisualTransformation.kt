package uz.toshmatov.wedrive.core.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class ExpiryDateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.take(4).filter { it.isDigit() }
        val out = StringBuilder()

        for (i in trimmed.indices) {
            if (i == 2) out.append("/")
            out.append(trimmed[i])
        }

        val offsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return if (offset <= 2) offset else offset + 1
            }

            override fun transformedToOriginal(offset: Int): Int {
                return if (offset <= 2) offset else offset - 1
            }
        }

        return TransformedText(AnnotatedString(out.toString()), offsetTranslator)
    }
}
