package com.example.myapplicat


import android.os.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Model (
    @SerialName("image") val picture: String?
)