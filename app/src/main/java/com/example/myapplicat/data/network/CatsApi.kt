package com.example.myapplicat.data.network

import com.example.myapplicat.data.model.ModelCategories
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatsApi {
    @GET("breeds")
    suspend fun loadCats(): List<ModelCategories>

    @GET("breeds/{cat_id}")
    suspend fun getCats(
        @Path("cat_id") catId: String?,
    ): ModelCategories
}