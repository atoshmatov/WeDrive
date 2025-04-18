package uz.toshmatov.wedrive.core.image

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun imageToRequest(@DrawableRes image: Int): Any = ImageRequest.Builder(LocalContext.current)
    .data(image).crossfade(true).build()

@Composable
fun imageToRequest(image: String): Any = ImageRequest.Builder(LocalContext.current)
    .data(image).crossfade(true).build()