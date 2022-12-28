package me.ako.constraintlayoutkeyframe.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val author: String,
    val imgUrl: String
)