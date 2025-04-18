package uz.toshmatov.wedrive.core.utils

import android.content.Context
import android.widget.Toast

fun Context.makeToast(log: String) {
    Toast.makeText(this, log, Toast.LENGTH_LONG).show()
}