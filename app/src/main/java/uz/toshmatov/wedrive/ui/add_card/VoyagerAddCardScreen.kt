package uz.toshmatov.wedrive.ui.add_card

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.androidx.compose.koinViewModel
import uz.toshmatov.wedrive.core.logger.logInfo
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.uicomponent.CompletedButton
import uz.toshmatov.wedrive.core.uicomponent.WeDriveIcon
import uz.toshmatov.wedrive.core.uicomponent.WeDriveLoading
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.core.utils.weDriveString
import uz.toshmatov.wedrive.ui.add_card.component.AddCardItem
import uz.toshmatov.wedrive.ui.add_card.intent.AddCardEvents
import uz.toshmatov.wedrive.ui.add_card.intent.AddCardState

class VoyagerAddCardScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<AddCardViewModel>()
        val state = viewModel.state.collectAsState().value
        val navigator = LocalNavigator.currentOrThrow
        if (state.isLoading) {
            WeDriveLoading()
        } else {
            AddCardScreen(
                backClick = navigator::pop,
                reduce = viewModel::reduce,
                state = state,
            )
        }
    }
}

@Composable
private fun AddCardScreen(
    modifier: Modifier = Modifier,
    backClick: () -> Unit,
    state: AddCardState,
    reduce: (AddCardEvents) -> Unit = {},
) {
    var cardNumber by remember { mutableStateOf("") }
    var cardNumberDate by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
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
                text = weDriveString.add_card.resource,
                modifier = modifier,
                style = WeDriveTypography.buttonLarge,
                color = WeDriveColors.textSecondary,
            )
        }
        Spacer(Modifier.height(20.dp))
        AddCardItem(
            onCardNumberChange = {
                cardNumber = it
            },
            onCardNumberDateChange = {
                cardNumberDate = it
            }
        )
        Spacer(Modifier.weight(1f))
        CompletedButton(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding(),
            onCompleted = {
                reduce(
                    AddCardEvents.AddUserCard(
                        number = cardNumber,
                        expireDate = cardNumberDate
                    )
                )
                if (!state.isLoading) {
                    backClick()
                }
            },
            enabled = cardNumber.length <= 16 && cardNumberDate.length == 4,
            textContent = weDriveString.save.resource
        )
    }
}


