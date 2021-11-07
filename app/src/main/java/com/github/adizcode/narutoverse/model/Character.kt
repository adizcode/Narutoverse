package com.github.adizcode.narutoverse.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val imageResource: Int,
    val quote: String,
    val description: String,
) : Parcelable