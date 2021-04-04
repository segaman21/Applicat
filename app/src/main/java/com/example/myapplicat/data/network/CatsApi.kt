package com.example.myapplicat.data.network

import com.example.myapplicat.data.model.Model
import com.example.myapplicat.data.model.ModelCategories
import retrofit2.http.GET

interface CatsApi {
    @GET("breeds")
    suspend fun loadCats(): List<ModelCategories>
}