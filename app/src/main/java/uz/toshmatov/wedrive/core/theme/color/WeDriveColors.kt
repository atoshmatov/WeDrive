package uz.toshmatov.wedrive.core.theme.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class WeDriveColors(
    background: Color,
    itemBackground: Color,
    text: Color,
    textSecondary: Color,
    textPrimary: Color,
    textGray: Color,
    icon: Color,
    button: Color,
    buttonEnable: Color,
    buttonContent: Color,
    error: Color,
    success: Color,
    iconChecked: Color,
    switch: Color,
    divider: Color,
    bottomBar: Color,
    bottomBarIconUnSelected: Color,
    bottomBarIconSelected: Color,
    placeHolder: Color,
) {
    var background by mutableStateOf(background)
        private set

    var itemBackground by mutableStateOf(itemBackground)
        private set

    var text by mutableStateOf(text)
        private set

    var textSecondary by mutableStateOf(textSecondary)
        private set

    var textPrimary by mutableStateOf(textPrimary)
        private set

    var textGray by mutableStateOf(textGray)
        private set

    var icon by mutableStateOf(icon)
        private set

    var button by mutableStateOf(button)
        private set

    var buttonEnable by mutableStateOf(buttonEnable)
        private set

    var buttonContent by mutableStateOf(buttonContent)
        private set

    var error by mutableStateOf(error)
        private set

    var success by mutableStateOf(success)
        private set

    var iconChecked by mutableStateOf(iconChecked)
        private set

    var switch by mutableStateOf(switch)
        private set

    var divider by mutableStateOf(divider)
        private set

    var bottomBar by mutableStateOf(bottomBar)
        private set

    var bottomBarIconUnSelected by mutableStateOf(bottomBarIconUnSelected)
        private set

    var bottomBarIconSelected by mutableStateOf(bottomBarIconSelected)
        private set

    var placeHolder by mutableStateOf(placeHolder)
        private set

    fun copy(
        background: Color = this.background,
        itemBackground: Color = this.itemBackground,
        text: Color = this.text,
        textSecondary: Color = this.textSecondary,
        textPrimary: Color = this.textPrimary,
        textGray: Color = this.textGray,
        icon: Color = this.icon,
        button: Color = this.button,
        buttonEnable: Color = this.buttonEnable,
        buttonContent: Color = this.buttonContent,
        error: Color = this.error,
        success: Color = this.success,
        iconChecked: Color = this.iconChecked,
        switch: Color = this.switch,
        divider: Color = this.divider,
        bottomBar: Color = this.bottomBar,
        bottomBarIconUnSelected: Color = this.bottomBarIconUnSelected,
        bottomBarIconSelected: Color = this.bottomBarIconSelected,
        placeHolder: Color = this.placeHolder,
    ) = WeDriveColors(
        background = background,
        itemBackground = itemBackground,
        text = text,
        textSecondary = textSecondary,
        textPrimary = textPrimary,
        textGray = textGray,
        icon = icon,
        button = button,
        buttonEnable = buttonEnable,
        buttonContent = buttonContent,
        error = error,
        success = success,
        iconChecked = iconChecked,
        switch = switch,
        divider = divider,
        bottomBar = bottomBar,
        bottomBarIconUnSelected = bottomBarIconUnSelected,
        bottomBarIconSelected = bottomBarIconSelected,
        placeHolder = placeHolder,
    )

    fun updateColorsFrom(other: WeDriveColors) {
        background = other.background
        itemBackground = other.itemBackground
        text = other.text
        textSecondary = other.textSecondary
        textPrimary = other.textPrimary
        textGray = other.textGray
        icon = other.icon
        button = other.button
        buttonEnable = other.buttonEnable
        buttonContent = other.buttonContent
        error = other.error
        success = other.success
        iconChecked = other.iconChecked
        switch = other.switch
        divider = other.divider
        bottomBar = bottomBar
        bottomBarIconUnSelected = bottomBarIconUnSelected
        bottomBarIconSelected = bottomBarIconSelected
        placeHolder = placeHolder
    }
}