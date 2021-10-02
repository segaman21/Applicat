
package com.example.myapplicat.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class NetworkModule {
    private val json = Json {
        isLenient = true
        prettyPrint = true
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    private val baseUrl = "https://api.thecatapi.com/v1/"
    private val contentType = "application/json; charset=utf-8".toMediaType()

    fun provideApi(): CatsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
        return retrofit.create(CatsApi::class.java)
    }
}
