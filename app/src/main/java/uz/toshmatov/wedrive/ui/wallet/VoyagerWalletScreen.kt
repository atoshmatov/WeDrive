package uz.toshmatov.wedrive.ui.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.androidx.compose.koinViewModel
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveString
import uz.toshmatov.wedrive.ui.add_card.VoyagerAddCardScreen
import uz.toshmatov.wedrive.ui.add_promo_code.VoyagerAddPromoCodeSheet
import uz.toshmatov.wedrive.ui.wallet.component.AddCard
import uz.toshmatov.wedrive.ui.wallet.component.CardItem
import uz.toshmatov.wedrive.ui.wallet.component.IdentificationItem
import uz.toshmatov.wedrive.ui.wallet.component.PaymentOptions
import uz.toshmatov.wedrive.ui.wallet.component.WalletBalance
import uz.toshmatov.wedrive.ui.wallet.intent.WallerEvents
import uz.toshmatov.wedrive.ui.wallet.intent.WallerEvents.*
import uz.toshmatov.wedrive.ui.wallet.intent.WalletState
import uz.toshmatov.wedrive.ui.wallet.model.PaymentOptionsType

class VoyagerWalletScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<WalletViewModel>()
        val state = viewModel.state.collectAsState()

        val navigator = LocalNavigator.currentOrThrow
        val bottomSheetNavigator = LocalBottomSheetNavigator.current

        WalletScreen(
            state = state.value,
            reduce = viewModel::reduce,
            openAddCardScreen = {
                navigator.push(VoyagerAddCardScreen())
            },
            showPromoCodeBottomSheet = {
                bottomSheetNavigator.show(VoyagerAddPromoCodeSheet())
            }
        )
    }
}

@Composable
private fun WalletScreen(
    modifier: Modifier = Modifier,
    state: WalletState = WalletState(),
    reduce: (WallerEvents) -> Unit,
    openAddCardScreen: () -> Unit,
    showPromoCodeBottomSheet: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(WeDriveColors.background)
            .padding(horizontal = WeDriveDimensions.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(Modifier.height(12.dp))
        Text(
            text = weDriveString.wallet.resource,
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            style = WeDriveTypography.buttonLarge,
            color = WeDriveColors.textSecondary,
        )
        Spacer(Modifier.height(22.dp))
        WalletBalance(
            walletBalance = state.userWalletBalance,
            walletPhoneNumber = state.userWalletPhone
        )
        Spacer(Modifier.height(24.dp))
        IdentificationItem()
        Spacer(Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                items = state.paymentOptionModels,
                key = { it.title },
            ) {
                PaymentOptions(
                    itemClick = {
                        when (it) {
                            PaymentOptionsType.PromoCode -> {
                                showPromoCodeBottomSheet()
                            }

                            PaymentOptionsType.Cash -> TODO()
                        }
                    },
                    paymentOptionsModel = it,
                    inCashChecked = {
                        reduce(
                            WallerEvents.UserWalletPaymentMethod(
                                activeMethod = if (it) "cash" else "card",
                                activeCardId = 1
                            )
                        )
                    },
                    cashChecked = state.userWalletActiveMethod == "cash"
                )
            }
            items(
                items = state.userCards,
                key = { it.id },
            ) { userCards ->
                CardItem(
                    itemClick = {},
                    userCardsM = userCards
                )
            }
            item {
                AddCard { openAddCardScreen() }
            }
        }
    }
}