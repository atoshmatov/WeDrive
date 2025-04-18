package uz.toshmatov.wedrive.core.utils

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.toshmatov.wedrive.R

typealias weDriveString = R.string
typealias weDriveDrawable = R.drawable
typealias weDriveFont = R.font

@get:SuppressLint("SupportAnnotationUsage")
@get:StringRes
val Int.resource: String
    @Composable
    get() = stringResource(id = this)
