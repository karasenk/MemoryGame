package com.example.game.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardModel(
    val imgPath: String,
    var isOpened: Boolean
) : Parcelable