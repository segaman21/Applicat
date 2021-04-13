package com.example.myapplicat.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModelCategories(
    @SerialName("name") val name: String?,
    @SerialName("id") val id: String,
    @SerialName("origin") val origin: String?,
    @SerialName("temperament") val temperament: String?,
    @SerialName("description") val description: String?,
    //@SerialName("life_span") val life: Int,
    @SerialName("image") val image: ModelImage?=null,

)

@Serializable
data class ModelImage(
    @SerialName("url") val url: String?=null,
    @SerialName("id") val id: String?=null,
    @SerialName("width") val width: Int?=null,
    @SerialName("height") val height: Int?=null
)