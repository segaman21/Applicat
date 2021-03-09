package com.example.myapplicat.network
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class NetworkModule {

    private val baseUrl = "https://api.thecatapi.com/v1/"

    fun provideApi(): MoviesApi {
        val retrofit= Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MoviesApi::class.java)
    }
}