package uz.toshmatov.wedrive.core.lingver

import android.content.Context
import com.yariksoffice.lingver.Lingver

class LingverLocalization {
    fun setLocale(
        context: Context,
        languageCode: String,
    ) {
        Lingver.getInstance().setLocale(context, languageCode)
    }
}
