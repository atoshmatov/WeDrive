package uz.toshmatov.wedrive.ui.add_promo_code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import org.koin.androidx.compose.koinViewModel
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.uicomponent.CompletedButton
import uz.toshmatov.wedrive.core.uicomponent.WeDriveIcon
import uz.toshmatov.wedrive.core.utils.makeToast
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.core.utils.weDriveString
import uz.toshmatov.wedrive.ui.add_promo_code.intent.PromoCodeEvents

class VoyagerAddPromoCodeSheet : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PromoCodeViewModel>()
        val state by viewModel.state.collectAsState()
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current


        AddPromoCodeScreen(
            backClick = {
                keyboardController?.hide()
                bottomSheetNavigator.hide()
            },
            reduce = viewModel::reduce,
        )
        if (state.success) {
            context.makeToast(state.message)
            keyboardController?.hide()
            bottomSheetNavigator.hide()
        }
    }
}

@Composable
private fun AddPromoCodeScreen(
    modifier: Modifier = Modifier,
    backClick: () -> Unit,
    reduce: (PromoCodeEvents) -> Unit,
) {
    var promoCode by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(
                color = WeDriveColors.background
            )
            .padding(horizontal = WeDriveDimensions.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = WeDriveDimensions.betweenItems),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            WeDriveIcon(
                image = weDriveDrawable.ic_arrow_left,
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = CircleShape
                    )
                    .background(
                        color = WeDriveColors.background,
                        shape = CircleShape
                    ),
                onClick = backClick
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = weDriveString.promo_code.resource,
                modifier = modifier,
                style = WeDriveTypography.buttonLarge,
                color = WeDriveColors.textSecondary,
            )
        }
        Spacer(Modifier.height(20.dp))
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { newText ->
                text = newText
                promoCode = newText.text
            },
            textStyle = WeDriveTypography.buttonLarge,
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = WeDriveColors.background,
                unfocusedContainerColor = WeDriveColors.background,
                focusedIndicatorColor = WeDriveColors.divider,
                unfocusedIndicatorColor = WeDriveColors.divider,
            )
        )
        Spacer(Modifier.height(20.dp))
        CompletedButton(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding(),
            onCompleted = {
                reduce(PromoCodeEvents.AddPromoCode(promoCode))
            },
            enabled = promoCode.isNotEmpty(),
            textContent = weDriveString.save.resource
        )
    }
}