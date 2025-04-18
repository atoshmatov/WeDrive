@file:OptIn(ExperimentalMaterialApi::class)

package uz.toshmatov.wedrive.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveTheme
import uz.toshmatov.wedrive.ui.wallet.VoyagerWalletScreen

class WeDriveActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb(),
            ),
            navigationBarStyle = SystemBarStyle.light(
                scrim = Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb(),
            )
        )
        setContent {
            WeDriveTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(WeDriveColors.background)
                ) {
                    BottomSheetNavigator(
                        modifier = Modifier
                            .animateContentSize(),
                        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                    ) {
                        Navigator(VoyagerWalletScreen()) {
                            SlideTransition(it)
                        }
                    }
                }
            }
        }
    }
}