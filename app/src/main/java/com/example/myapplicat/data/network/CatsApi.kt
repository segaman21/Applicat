package com.example.myapplicat.data.network

import com.example.myapplicat.data.model.Model
import retrofit2.http.GET

interface CatsApi {
    @GET("images/search")
    suspend fun loadCats(): List<Model>
}