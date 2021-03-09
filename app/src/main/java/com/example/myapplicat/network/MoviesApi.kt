package com.example.myapplicat.network

import com.example.myapplicat.Model
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("images/search")
    suspend fun loadMovies(): Model
}