package com.example.myapplicat.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModelCategories(
    @SerialName("name") val name: String?,
    @SerialName("origin") val origin: String?,
    @SerialName("temperament") val temperament: String?,
    @SerialName("description") val description: String?,
    @SerialName("image") val image: ModelImage?
)

@Serializable
data class ModelImage(
    @SerialName("url") val url: String,
    @SerialName("id") val id: String,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int
)