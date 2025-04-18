package uz.toshmatov.wedrive.core.uicomponent

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.toshmatov.wedrive.core.theme.WeDriveColors
import uz.toshmatov.wedrive.core.theme.WeDriveDimensions
import uz.toshmatov.wedrive.core.theme.WeDriveTypography
import uz.toshmatov.wedrive.core.utils.resource
import uz.toshmatov.wedrive.core.utils.weDriveDrawable
import uz.toshmatov.wedrive.core.utils.weDriveString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    @StringRes placeHolderResId: Int = weDriveString.home_search,
    onValueChange: (String) -> Unit,
    onFocus: () -> Unit = {},
) {
    var text by rememberSaveable { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(text)
        },
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(WeDriveColors.bottomBar)
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    onFocus()
                }
            },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = WeDriveColors.text,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
        ),
        interactionSource = interactionSource,
        cursorBrush = SolidColor(WeDriveColors.text)
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = innerTextField,
            placeholder = {
                Text(
                    text = placeHolderResId.resource,
                    color = WeDriveColors.placeHolder,
                    style = WeDriveTypography.bodyMedium,
                )
            },
            enabled = true,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = WeDriveColors.icon,
                unfocusedLeadingIconColor = WeDriveColors.icon,
                focusedContainerColor = WeDriveColors.bottomBar,
                unfocusedContainerColor = WeDriveColors.bottomBar,
                focusedIndicatorColor = WeDriveColors.bottomBar,
                unfocusedIndicatorColor = WeDriveColors.bottomBar,
                cursorColor = WeDriveColors.text,
                focusedTextColor = WeDriveColors.text,
                unfocusedTextColor = WeDriveColors.text,
                disabledTextColor = WeDriveColors.textSecondary
            ),
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            leadingIcon = {
                WeDriveIcon(
                    image = weDriveDrawable.ic_search,
                    size = 16.dp,
                    contentDescription = "search"
                )
            },
            trailingIcon = {
                AnimatedVisibility(
                    visible = text.isNotBlank(),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    WeDriveIcon(
                        image = weDriveDrawable.ic_close,
                        size = 16.dp,
                        contentDescription = "search",
                        tint = WeDriveColors.textSecondary,
                        onClick = {
                            text = ""
                            onValueChange(text)
                        }
                    )
                }
            },
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = WeDriveDimensions.none,
                bottom = WeDriveDimensions.none,
            ),
        )
    }
}