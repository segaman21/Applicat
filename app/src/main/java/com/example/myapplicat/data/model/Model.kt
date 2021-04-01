package com.example.myapplicat.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Model (
    @SerialName("url") val picture: String?
)